<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formFormulaHospitalizacion">
  <a4j:region id="regionFormulaHospitalizacion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionFormulaHospitalizacion">
      <f:facet name="start">
        <t:div id="chargingFormulaHospitalizacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
   
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneAldrete" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabAldret" label="Aldrete ">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAldrete"
                     styleClass="tabContainer">
          <s:fieldset legend="Cirugia(s) Programada(s)" id="fieldCirugiasAldrete" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAldrete"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Intervención(es)"/>
              <h:outputText/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0"
                         rendered="#{not empty registrarEscalaAldreteBean.lstCirugias}" cellspacing="0" width="100%"
                         id="tableCirugiasProgramadasAldrete" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                             binding="#{registrarEscalaAldreteBean.dtCirugias}"
                             value="#{registrarEscalaAldreteBean.lstCirugias}" rows="10" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                             id="dtCirugiasProgramadasAldrete">
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
                  <t:dataScroller id="scroll_aldrete" for="dtCirugiasProgramadasAldrete" fastStep="10"
                                  pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                  paginator="true" immediate="true" paginatorMaxPages="9"
                                  paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
          <s:fieldset legend="Datos Aldrete" id="fieldAldrete" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAldrete"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Actividad " styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value="Respiración" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:selectOneMenu id="mnuActividad" required="true"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halnactividad}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstActividad}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuActividad" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:selectOneMenu id="mnuRespiracion" required="true"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halnrespiracio}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstRespiracion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuRespiracion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="Circulación " styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value="Estado de consciencia" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:selectOneMenu id="mnuCirculacion" required="true"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halncirculacio}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstCirculacion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuCirculacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:selectOneMenu id="mnuEstadoConsciencua" required="true"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halnestadconci}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstEstadoConciencia}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuEstadoConsciencua" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="Saturación de oxígeno  " styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:selectOneMenu id="mnuSaturacion" required="true"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halnsaturoxige}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstSaturacion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuSaturacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=""/>
              <h:outputText value=""/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Ambulatorio" id="fieldAmbulatorio" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAmbulatorio"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="El paciente es ambulatorio " styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuAmbulatorio" required="true"
                                  value="#{registrarEscalaAldreteBean.aldreteObject.halcpacieambul}"
                                  valueChangeListener="#{registrarEscalaAldreteBean.setHalcpacieambul}">
                  <f:selectItems value="#{registrarEscalaAldreteBean.lstOpciones}"/>
                  <a4j:support id="supportAmbulatorio" event="onclick"
                               action="#{registrarEscalaAldreteBean.changeAmbulatorio}" reRender="fieldAmbulatorio">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAmbulatorio" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=" Ambulación " styleClass="labelTextOblig"
                            rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
              <h:outputText value=""/>
              <h:outputText value=" Dolor" styleClass="labelTextOblig"
                rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
              <h:outputText value=""/>
              <h:selectOneMenu id="mnuAmbulacion" required="true"
                               rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halnambulacion}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstAmbulacion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                <t:message for="mnuAmbulacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:selectOneMenu id="mnuDolor" required="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halndolor}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstDolor}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                <t:message for="mnuDolor" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=" Sangrado postquirúrgico " styleClass="labelTextOblig"
                            rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
              <h:outputText value=""/>
              <h:outputText value=" Tolerancia a los líquidos por vía oral" styleClass="labelTextOblig"
                            rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
              <h:outputText value=""/>
              <h:selectOneMenu id="mnuSangrado" required="true"
                               rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halnsangrposqu}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstSangrado}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                <t:message for="mnuSangrado" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:selectOneMenu id="mnuTolerancia" required="true"
                               rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halntolerliqui}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstTolerancia}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                <t:message for="mnuTolerancia" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=" Eliminación urinaria " styleClass="labelTextOblig"
                            rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:selectOneMenu id="mnuEliminacion" required="true"
                               rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                               value="#{registrarEscalaAldreteBean.aldreteObject.halnelimiurina}">
                <f:selectItems value="#{registrarEscalaAldreteBean.lstEliminacion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                <t:message for="mnuEliminacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=""/>
              <h:outputText value=""/>
            </h:panelGrid>
          </s:fieldset>
          
         <s:fieldset legend="Calcular Escala" id="fieldCalcularEscala" styleClass="fieldset">
         <h:panelGrid style="text-align:left" columns="1" id="panelCalcAldrete" border="0" cellpadding="0"
                       cellspacing="0" width="90%">
            <h:outputText value="#{registrarEscalaAldreteBean.numeroEscala}" styleClass="labelTextUnderLine2"
            rendered="#{registrarEscalaAldreteBean.numeroEscala}"/>
            </h:panelGrid>
          </s:fieldset>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAldrete"
                       columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                               action="#{registrarEscalaAldreteBean.aceptar}">
                <a4j:support event="onclick" status="statusButton"/>
              </h:commandButton>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid style="text-align:left" columns="1" id="panelTotalAdmin" border="0" cellpadding="0"
                       cellspacing="0" width="90%">
            <h:outputText value=" "/>
            <h:panelGroup>
              <h:outputText value="#{registrarEscalaAldreteBean.msgAdvertencia}" styleClass="labelTextBlueUnderLine"/>
               <t:htmlTag value="br"/>
              <h:outputText value="#{registrarEscalaAldreteBean.msgAdvertencia2}" styleClass="labelTextBlueUnderLine"/>
               <t:htmlTag value="br"/>
              <h:outputText value="#{registrarEscalaAldreteBean.msgAdvertencia3}" styleClass="labelTextBlueUnderLine"/>
            </h:panelGroup>
          </h:panelGrid>
        </h:panelGrid>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMessagesAldrete" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInformationAndErrorsAldrete" showSummary="true" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:commandLink action="irListaNotasEnfermeria" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </t:panelTab>
    </t:panelTabbedPane>
  </a4j:region>
</a4j:form>