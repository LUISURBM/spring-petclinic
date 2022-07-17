<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormularMedicamentosTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneFormulaHospitalizacion" styleClass="tabbedPane"
                     selectedIndex="#{formulaHospitalizacionBean.selectedIndex}" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPrescripcionHospitalizacion" label="Prescripción Medicamentos" disabled="#{formulaHospitalizacionBean.renderBuscador}">
      <a4j:region renderRegionOnly="false">
        <s:fieldset legend="" id="fieldProfilaxis" styleClass="fieldset" rendered="#{formulaHospitalizacionBean.renderProfilaxis}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridTipoViolencia" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Profilaxis antitrombótica"/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkProfilaxis" onkeydown="return blockEnter(event);" value="#{formulaHospitalizacionBean.renderAntitrombotica}"
                                       valueChangeListener="#{formulaHospitalizacionBean.setRenderAntitrombotica}" immediate="true">
                <a4j:support id="support_antitrombotica" event="onclick" immediate="true" reRender="panelGridFormularMedicamentosTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:outputText value="Profilaxis antibiotica"/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkProfilaxisAntibiotica" onkeydown="return blockEnter(event);" value="#{formulaHospitalizacionBean.renderAntibiotica}"
                                       valueChangeListener="#{formulaHospitalizacionBean.setRenderAntibiotica}" immediate="true">
                <a4j:support id="support_antibiotica" event="onclick" immediate="true" reRender="panelGridFormularMedicamentosTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="" id="fieldAnalgesia" styleClass="fieldset" rendered="#{formulaHospitalizacionBean.renderAnalgesiaPosoperatoria}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAnalgesia" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Analgesia"/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkAnalgesia" onkeydown="return blockEnter(event);" value="#{formulaHospitalizacionBean.renderAnalgesia}"
                                       valueChangeListener="#{formulaHospitalizacionBean.setRenderAnalgesia}" immediate="true">
                <a4j:support id="support_analgesia" event="onclick" immediate="true" reRender="panelTabPrescripcionHospitalizacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Analgesia Posoperatoria" rendered="#{formulaHospitalizacionBean.renderAnalgesia && formulaHospitalizacionBean.renderAnalgesiaPosoperatoria}" id="fieldListaAnalgesia"
                    styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAnalgesiaTable" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{formulaHospitalizacionBean.lstAnalgesiaPosoperatoria}" rows="10" styleClass="standard_table"
                           binding="#{formulaHospitalizacionBean.dtAnalgesia}" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtAnalgesia">
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
                    <h:outputText value="Frecuencia (Horas)"/>
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
                    <h:outputText value="Observaciones"/>
                  </f:facet>
                  <h:outputText value="#{item.wdesforma}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Adicionar"/>
                  </f:facet>
                  <a4j:commandLink id="adicionarAnalgesia" immediate="true" reRender="panelTabPrescripcionHospitalizacion" action="#{formulaHospitalizacionBean.agregarAnalgesia}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/fnd_boton_agregar.gif"/>
                  </a4j:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Analgesia" for="dtAnalgesia" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
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
            <s:fieldset legend="Profilaxis antitrombótica" rendered="#{formulaHospitalizacionBean.renderAntitrombotica && formulaHospitalizacionBean.renderProfilaxis}" id="fieldListaProfilaxis"
                    styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" rendered="#{not empty formulaHospitalizacionBean.lstProfilaxisAntitrombotica}" width="100%"
                       id="panelProfilaxisAntitromboticaTable" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{formulaHospitalizacionBean.lstProfilaxisAntitrombotica}" rows="10" styleClass="standard_table"
                           binding="#{formulaHospitalizacionBean.dtAntitrombotica}" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtAntitrombotica">
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
                    <h:outputText value="Frecuencia (Horas)"/>
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
                    <h:outputText value="Observaciones"/>
                  </f:facet>
                  <h:outputText value="#{item.wdesforma}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Adicionar"/>
                  </f:facet>
                  <a4j:commandLink id="adicionarAntitrombotica" immediate="true" reRender="panelGridFormularMedicamentosTab" action="#{formulaHospitalizacionBean.agregarAntitrombotica}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/fnd_boton_agregar.gif"/>
                  </a4j:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Antitromboticol" for="dtAntitrombotica" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
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
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Profilaxis antibiótica" rendered="#{formulaHospitalizacionBean.renderProfilaxis  && formulaHospitalizacionBean.renderAntibiotica}" id="fieldListaProfilaxisAntibiotica"
                    styleClass="fieldset">
          <h:panelGrid style="text-align:left" columns="1" id="panelTotalAdmin" border="0" cellpadding="0" cellspacing="0" width="90%">
            <h:outputText value="#{formulaHospitalizacionBean.msgMedicamento}" styleClass="labelTextBlueUnderLine"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" rendered="#{not empty formulaHospitalizacionBean.lstProfilaxisAntibiotica}" width="100%"
                       id="panelProfilaxisAntibioticaTable" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{formulaHospitalizacionBean.lstProfilaxisAntibiotica}" binding="#{formulaHospitalizacionBean.dtAntibiotica}"
                           rows="10" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtAntibiotica">
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
                    <h:outputText value="Frecuencia (Horas)"/>
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
                    <h:outputText value="Observaciones"/>
                  </f:facet>
                  <h:outputText value="#{item.wdesforma}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Adicionar"/>
                  </f:facet>
                  <a4j:commandLink id="adicionarAntibiotica" immediate="true" reRender="panelGridFormularMedicamentosTab" action="#{formulaHospitalizacionBean.agregarAntibiotica}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/fnd_boton_agregar.gif"/>
                  </a4j:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_dtAntibiotica" for="dtAntibiotica" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
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
        <s:fieldset legend="Médicamentos Formulados" id="fieldHistorialLista" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridConsultarHistorialFormulados" rendered="#{empty formulaHospitalizacionBean.lstHistorialPrescrpcion}">
            <h:outputText value="#{msg.msg_sin_medicamentos_formulados}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelHistorialTable" rendered="#{not empty formulaHospitalizacionBean.lstHistorialPrescrpcion}"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{formulaHospitalizacionBean.lstHistorialPrescrpcion}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtHistorial">
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
                    <h:outputText value="Frecuencia (Horas)"/>
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
                    <h:outputText value="Observaciones"/>
                  </f:facet>
                  <h:outputText value="#{item.wdesforma}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Suspender"/>
                  </f:facet>
                  <h:selectBooleanCheckbox id="checkSuspenderMedicamentos" disabled="#{!item.hfhbrendersusp}" onkeydown="return blockEnter(event);" value="#{item.hfhbsuspender}"></h:selectBooleanCheckbox>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Historial" for="dtHistorial" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
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
      </a4j:region>
      <a4j:region renderRegionOnly="false">
        <s:fieldset legend="Médicamentos Formulados Consulta Externa" id="fieldHistorialConsultaExterna" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridConsultarHistorialFormuladosConsultaExterna" rendered="#{empty formulaHospitalizacionBean.lstHistorialExterna}">
            <h:outputText value="#{msg.msg_sin_medicamentos_formulados}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelHistorialConsultaExternaTable"
                       rendered="#{not empty formulaHospitalizacionBean.lstHistorialExterna}" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{formulaHospitalizacionBean.lstHistorialExterna}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtHistorialExterna">
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
                    <h:outputText value="Frecuencia (Horas)"/>
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
                    <h:outputText value="Observaciones"/>
                  </f:facet>
                  <h:outputText value="#{item.wdesforma}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Suspender"/>
                  </f:facet>
                  <h:selectBooleanCheckbox id="checkSuspenderMedicamentosExterna" disabled="#{!item.hfhbrendersusp}" onkeydown="return blockEnter(event);" value="#{item.hfhbsuspender}"></h:selectBooleanCheckbox>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Historial_externa" for="dtHistorialExterna" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
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
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaHospitalizacion" styleClass="tabContainer">
        <s:fieldset legend="Conciliación Medicamentosa" id="fieldConciliación" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosConciliacion" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Se realizo reconciliación medicamentosa?" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:selectOneRadio id="selectConciliación" required="true" immediate="true" value="#{formulaHospitalizacionBean.conciliacionMedicamentosa}"
                              valueChangeListener="#{formulaHospitalizacionBean.setConciliacionMedicamentosa}">
              <f:selectItems value="#{formulaHospitalizacionBean.listOpciones}"/>
              <a4j:support id="support7" action="#{formulaHospitalizacionBean.confirmaConciliacion}" event="onchange" immediate="true">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="selectConciliación" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:selectOneRadio>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Prescripción Medicamentos" id="fieldFormulaHospitalizacion" styleClass="fieldset">
          <a4j:region id="regionFormulaHospitalizacion" renderRegionOnly="false">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosFormulaHospitalizacion" rowClasses="labelText">
              <h:outputText value="Nombre genérico del medicamento formulado" styleClass="labelTextOblig"/>
              <h:outputText value="Presentación del medicamento" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <a4j:commandLink action="#{formulaHospitalizacionBean.renderMedicamentos}" immediate="true" reRender="panelGridFormularMedicamentosTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                  </a4j:commandLink>
                  <h:outputText id="itMedicamento"  value="#{formulaHospitalizacionBean.medicamentoSelect}"                                    />
                </a4j:region>
              </h:panelGroup>
                <h:outputText id="itPresentacion" value="#{formulaHospitalizacionBean.presentacionSelect}" />
              <h:panelGrid columns="3">
                <h:outputText value="Dosis" styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Unidad de medida interna" styleClass="labelTextOblig"/>                
              </h:panelGrid>
              <h:panelGrid columns="2">
                <h:outputText value="Número de Dosis" styleClass="labelTextOblig"/>
                <h:outputText/>
              </h:panelGrid>
              <h:panelGrid columns="3">
                <h:inputText id="itDosis" required="false" maxlength="4" value="#{formulaHospitalizacionBean.dosisSelect}" style="width:40px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDosis" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="#{formulaHospitalizacionBean.unidadSelect}"/>
              </h:panelGrid>
              <h:panelGrid columns="7">
                <h:panelGroup>
                  <h:inputText id="itFrecuencia" required="false" maxlength="2" style="width:40px" value="#{formulaHospitalizacionBean.frecuenciaAdm}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itFrecuencia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Frecuencia: " styleClass="labelTextOblig"/>
                <h:inputText id="itTottiempo" required="false" maxlength="4" value="#{formulaHospitalizacionBean.tiempoTotal}" style="width:40px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itTottiempo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="mnuTiempo" required="false" value="#{formulaHospitalizacionBean.tiempoSelect}">
                  <f:selectItems value="#{formulaHospitalizacionBean.lstUnidadTiempo}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTiempo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosViaAdministracion" rowClasses="labelText">
              <h:outputText value="Vía de administración" styleClass="labelTextOblig"/>
              <h:panelGroup id="outputRecomendaciones">
                <h:outputText value="Recomendaciones" rendered="#{formulaHospitalizacionBean.mostrarIntravenosa}" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuVia" required="false" immediate="true" value="#{formulaHospitalizacionBean.viaSelect}" valueChangeListener="#{formulaHospitalizacionBean.setViaSelect}">
                    <f:selectItems value="#{formulaHospitalizacionBean.lstVia}"/>
                    <a4j:support id="supportmnuViaAdministracion" event="onchange" immediate="true" action="#{formulaHospitalizacionBean.ChangeViaAdministracion}"
                                 reRender="outputRecomendaciones,panelmnuRecomendacion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuVia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelmnuRecomendacion">
                <h:inputTextarea id="itRecomendacion" required="false" rendered="#{formulaHospitalizacionBean.mostrarIntravenosa}" value="#{formulaHospitalizacionBean.recoIntravenosa}"
                                 style="width:300px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itRecomendacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAgregarFormula" columnClasses="columnaBotones">
              <h:panelGroup>
                <t:htmlTag value="br"/>
                <a4j:commandButton value="Agregar" styleClass="btn btn btn-success" action="#{formulaHospitalizacionBean.agregarPrescripcion}" reRender="panelGridFormulaHospitalizacion"/>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <s:fieldset legend="Formula Medicamentos" id="fieldHospitalizacionLista" rendered="#{not empty formulaHospitalizacionBean.lstPrescripciones}" styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelFormulacionTable" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" binding="#{formulaHospitalizacionBean.dtFormula}" cellspacing="0" value="#{formulaHospitalizacionBean.lstPrescripciones}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtFormula">
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
                        <h:outputText value="Observaciones"/>
                      </f:facet>
                      <h:outputText value="#{item.wdesforma}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <a4j:commandLink id="eliminar" immediate="true" onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }" reRender="panelGridFormulaHospitalizacion"
                                       action="#{formulaHospitalizacionBean.eliminarFormula}">
                        <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                      </a4j:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtFormula" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
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
          </a4j:region>
        </s:fieldset>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
          <h:commandButton value="Generar Formula" styleClass="btn btn btn-success" action="#{formulaHospitalizacionBean.generarFormula}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGrid>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionFormulaHospitalizacionMsg" ajaxRendered="true">
              <t:messages id="msgFormulaHospitalizacionMsg" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscadorMedicamentos" label="Buscar Medicamentos" rendered="#{formulaHospitalizacionBean.renderBuscador}">
      <a4j:region id="regionMedicamento" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionMedicamento">
          <f:facet name="start">
            <t:div id="chargingMedicamento" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <a4j:region renderRegionOnly="false">
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorMedicamentos.jsp" flush="true"/>
        </a4j:region>
        <h:panelGrid id="panelGridMedicamentosBotones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupMedicamentosBotones1">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success" action="#{formulaHospitalizacionBean.aceptarMedicamento}" reRender="panelGridFormularMedicamentosTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
</h:panelGrid>