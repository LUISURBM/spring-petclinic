<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridBromageTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridBromageEnfermeriaTab" styleClass="tabContainer">
    <s:fieldset legend="Accesos Directos" id="accesosDirectos" styleClass="fieldset">
      <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAccesosDirectosBromage" rowClasses="labelText,labelTextInfo">
        <h:panelGrid columns="1" id="notasEnfermeriaBromage">
          <h:outputText value="Notas Enfermeria"/>
          <h:commandLink id="visualizarNotasEnfermeriaBromage" action="#{menuEnfermeriaBean.registrarNotasEnfermeria}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Prescription.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="liquidos">
          <f:facet name="header">
            <h:outputText value="Liquidos"/>
          </f:facet>
          <h:commandLink id="visualizarLiquidosBromage" action="#{menuEnfermeriaBean.registrarLiquidos}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Syringe.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="medicamentosBromage">
          <f:facet name="header">
            <h:outputText value="Medicamentos"/>
          </f:facet>
          <h:commandLink id="visualizarMedicamentos" action="#{menuEnfermeriaBean.registrarMedicamentos}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Vial-Pills.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="signosvitalesBromage">
          <f:facet name="header">
            <h:outputText value="Signos Vitales"/>
          </f:facet>
          <h:commandLink id="visualizarSignosVitalesBromage" action="#{menuEnfermeriaBean.registrarSignosVitales}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/RerunQualityControl.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="otrasOrdenes">
          <f:facet name="header">
            <h:outputText value="Otras Ordenes"/>
          </f:facet>
          <h:commandLink id="visualizarOtrasOrdenes" action="#{menuEnfermeriaBean.otrasOrdenes}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Edit.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="aldreteBromage" rendered="#{menuEnfermeriaBean.renderAldrete}">
          <f:facet name="header">
            <h:outputText value="Aldrete" rendered="#{menuEnfermeriaBean.renderAldrete}"/>
          </f:facet>
          <h:commandLink id="visualizarAldrete" action="#{menuEnfermeriaBean.registrarAldrete}" rendered="#{menuEnfermeriaBean.renderAldrete}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/BandAid.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="bromageBromage" rendered="#{menuEnfermeriaBean.renderBromage}">
          <f:facet name="header">
            <h:outputText value="Bromage" rendered="#{menuEnfermeriaBean.renderBromage}"/>
          </f:facet>
          <h:commandLink id="visualizarBromage" action="#{menuEnfermeriaBean.registrarBromage}" rendered="#{menuEnfermeriaBean.renderBromage}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/BandAid.png"/>
          </h:commandLink>
        </h:panelGrid>
      </h:panelGrid>
    </s:fieldset>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridNotaBromageTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneBromage" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAldret" label="Bromage ">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsBromage" styleClass="tabContainer">
            <s:fieldset legend="Cirugia(s) Programada(s)" id="fieldCirugiasBromage" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBromage" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Intervención(es)"/>
                <h:outputText/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty registrarEscalaAldreteBean.lstCirugias}" cellspacing="0" width="100%" id="tableCirugiasProgramadasBromage"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{registrarEscalaAldreteBean.dtCirugias}" value="#{registrarEscalaAldreteBean.lstCirugias}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtCirugiasProgramadasBromage">
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
                    <t:dataScroller id="scroll_bromage" for="dtCirugiasProgramadasBromage" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
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
            <s:fieldset legend="Historial Bromage" id="fieldCirugiasHistorialBromage" styleClass="fieldset" rendered="#{not empty registrarEscalaAldreteBean.lstHistorial}">
              <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty registrarEscalaAldreteBean.lstHistorial}" cellspacing="0" width="100%" id="tableCirugiasHistorialBromage"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{registrarEscalaAldreteBean.lstHistorial}" rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtCirugiasHistorialBromage">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Codigo"/>
                      </f:facet>
                      <h:outputText value="#{item.id.hallconsulta}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Consecutivo"/>
                      </f:facet>
                      <h:outputText value="#{item.id.hallconsecutiv}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Escala Bromage"/>
                      </f:facet>
                      <h:outputText value="#{item.halnescalbroma} #{item.halcdescraldet} "/>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_Historial_bromage" for="dtCirugiasHistorialBromage" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                    paginator="true" immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
            <s:fieldset legend="Datos Bromage" id="fieldAldrete" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAldrete" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Escala Bromage " styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:selectOneRadio id="mnuEscalaBromage" required="true" layout="pageDirection" value="#{registrarEscalaAldreteBean.bromageObject.halnescalbroma}">
                  <f:selectItems value="#{registrarEscalaAldreteBean.lstEscalaBromage}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEscalaBromage" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBromage" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{registrarEscalaAldreteBean.aceptarBromage}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesBromage" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrorsBromage" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:commandLink action="irListaNotasEnfermeria" immediate="true">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
          </h:commandLink>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </h:panelGrid>
</h:panelGrid>