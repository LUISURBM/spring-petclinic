<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoCirugiaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoEnfermeriaTab" styleClass="tabContainer">
    <s:fieldset legend="Accesos Directos" id="accesosDirectos" styleClass="fieldset">
      <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAccesosDirectos" rowClasses="labelText,labelTextInfo">
        <h:panelGrid columns="1" id="notasEnfermeria">
          <h:outputText value="Notas Enfermeria"/>
          <h:commandLink id="visualizarNotasEnfermeria" action="#{menuEnfermeriaBean.registrarNotasEnfermeria}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Prescription.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="liquidos">
          <f:facet name="header">
            <h:outputText value="Liquidos"/>
          </f:facet>
          <h:commandLink id="visualizarLiquidos" action="#{menuEnfermeriaBean.registrarLiquidos}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Syringe.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="medicamentos">
          <f:facet name="header">
            <h:outputText value="Medicamentos"/>
          </f:facet>
          <h:commandLink id="visualizarMedicamentos" action="#{menuEnfermeriaBean.registrarMedicamentos}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Vial-Pills.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="signosvitales">
          <f:facet name="header">
            <h:outputText value="Signos Vitales"/>
          </f:facet>
          <h:commandLink id="visualizarSignosVitales" action="#{menuEnfermeriaBean.registrarSignosVitales}" immediate="true">
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
        <h:panelGrid columns="1" id="aldrete" rendered="#{menuEnfermeriaBean.renderAldrete}">
          <f:facet name="header">
            <h:outputText value="Aldrete" rendered="#{menuEnfermeriaBean.renderAldrete}"/>
          </f:facet>
          <h:commandLink id="visualizarAldrete" action="#{menuEnfermeriaBean.registrarAldrete}" rendered="#{menuEnfermeriaBean.renderAldrete}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/BandAid.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="bromage" rendered="#{menuEnfermeriaBean.renderBromage}">
          <f:facet name="header">
            <h:outputText value="Bromage" rendered="#{menuEnfermeriaBean.renderBromage}"/>
          </f:facet>
          <h:commandLink id="visualizarBromage" action="#{menuEnfermeriaBean.registrarBromage}" rendered="#{menuEnfermeriaBean.renderBromage}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/BandAid.png"/>
          </h:commandLink>
        </h:panelGrid>
      </h:panelGrid>
    </s:fieldset>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridNotaEnfermeriaTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAldrete" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAldret" label="Aldrete ">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAldrete" styleClass="tabContainer">
            <s:fieldset legend="Cirugia(s) Programada(s)" id="fieldCirugiasAldrete" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAldrete" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Intervenci�n(es)"/>
                <h:outputText/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty registrarEscalaAldreteBean.lstCirugias}" cellspacing="0" width="100%" id="tableCirugiasProgramadasAldrete"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{registrarEscalaAldreteBean.dtCirugias}" value="#{registrarEscalaAldreteBean.lstCirugias}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtCirugiasProgramadasAldrete">
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
                    <t:dataScroller id="scroll_aldrete" for="dtCirugiasProgramadasAldrete" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
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
            <s:fieldset legend="Datos Aldrete" id="fieldAldrete" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAldrete" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Actividad " styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value="Respiraci�n" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuActividad" required="true" immediate="true" layout="pageDirection" value="#{registrarEscalaAldreteBean.aldreteObject.halnactividad}"
                                    valueChangeListener="#{registrarEscalaAldreteBean.setHalnactividad}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstActividad}"/>
                    <a4j:support id="supportActividad" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgActividad, panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgActividad" value="#{registrarEscalaAldreteBean.msgActividad}" style="color:blue; "/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuActividad" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuRespiracion" required="true" layout="pageDirection" immediate="true" value="#{registrarEscalaAldreteBean.aldreteObject.halnrespiracio}"
                                    valueChangeListener="#{registrarEscalaAldreteBean.setHalnrespiracio}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstRespiracion}"/>
                    <a4j:support id="supportRespiracion" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgRespiracion,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgRespiracion" value="#{registrarEscalaAldreteBean.msgRespiracion}" style="color:blue"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRespiracion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Circulaci�n " styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value="Estado de consciencia" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuCirculacion" required="true" layout="pageDirection" immediate="true" value="#{registrarEscalaAldreteBean.aldreteObject.halncirculacio}"
                                    valueChangeListener="#{registrarEscalaAldreteBean.setHalncirculacio}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstCirculacion}"/>
                    <a4j:support id="supportCirculacion" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgCirculacion,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgCirculacion" value="#{registrarEscalaAldreteBean.msgCirculacion}" style="color:blue"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCirculacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuEstadoConsciencia" required="true" layout="pageDirection" immediate="true" value="#{registrarEscalaAldreteBean.aldreteObject.halnestadconci}"
                                    valueChangeListener="#{registrarEscalaAldreteBean.setHalnestadconci}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstEstadoConciencia}"/>
                    <a4j:support id="supportEstadoConsciencia" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}"
                                 reRender="msgEstadoConsciencia,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgEstadoConsciencia" value="#{registrarEscalaAldreteBean.msgEstado}" style="color:blue"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEstadoConsciencia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Saturaci�n de ox�geno  " styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuSaturacion" required="true" immediate="true" layout="pageDirection" value="#{registrarEscalaAldreteBean.aldreteObject.halnsaturoxige}"
                                    valueChangeListener="#{registrarEscalaAldreteBean.setHalnsaturoxige}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstSaturacion}"/>
                    <a4j:support id="supportSaturacion" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgSaturacion,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgSaturacion" value="#{registrarEscalaAldreteBean.msgSaturacion}" style="color:blue"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuSaturacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value=""/>
                <h:outputText value=""/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Ambulatorio" id="fieldAmbulatorio" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAmbulatorio" rowClasses="labelText,labelTextInfo">
                <h:outputText value="El paciente es ambulatorio " styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAmbulatorio" required="true" value="#{registrarEscalaAldreteBean.aldreteObject.halcpacieambul}"
                                    valueChangeListener="#{registrarEscalaAldreteBean.setHalcpacieambul}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstOpciones}"/>
                    <a4j:support id="supportAmbulatorio" event="onclick" action="#{registrarEscalaAldreteBean.changeAmbulatorio}" reRender="fieldAmbulatorio">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAmbulatorio" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=" Ambulaci�n " styleClass="labelTextOblig" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                <h:outputText value=""/>
                <h:outputText value=" Dolor" styleClass="labelTextOblig" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuAmbulacion" required="true" layout="pageDirection" immediate="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                                    value="#{registrarEscalaAldreteBean.aldreteObject.halnambulacion}" valueChangeListener="#{registrarEscalaAldreteBean.setHalnambulacion}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstAmbulacion}"/>
                    <a4j:support id="supportAmbulacion" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgAmbulacion,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgAmbulacion" value="#{registrarEscalaAldreteBean.msgAmbulacion}" style="color:blue" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                  <t:message for="mnuAmbulacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuDolor" required="true" layout="pageDirection" immediate="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                                    value="#{registrarEscalaAldreteBean.aldreteObject.halndolor}" valueChangeListener="#{registrarEscalaAldreteBean.setHalndolor}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstDolor}"/>
                    <a4j:support id="supportDolor" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgDolor,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgDolor" value="#{registrarEscalaAldreteBean.msgDolor}" style="color:blue" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                  <t:message for="mnuDolor" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value=" Sangrado postquir�rgico " styleClass="labelTextOblig" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                <h:outputText value=""/>
                <h:outputText value=" Tolerancia a los l�quidos por v�a oral" styleClass="labelTextOblig" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuSangrado" required="true" layout="pageDirection" immediate="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                                    value="#{registrarEscalaAldreteBean.aldreteObject.halnsangrposqu}" valueChangeListener="#{registrarEscalaAldreteBean.setHalnsangrposqu}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstSangrado}"/>
                    <a4j:support id="supportSangrado" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgSangrado,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgSangrado" value="#{registrarEscalaAldreteBean.msgSangrado}" style="color:blue" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                  <t:message for="mnuSangrado" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuTolerancia" required="true" layout="pageDirection" immediate="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                                    value="#{registrarEscalaAldreteBean.aldreteObject.halntolerliqui}" valueChangeListener="#{registrarEscalaAldreteBean.setHalntolerliqui}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstTolerancia}"/>
                    <a4j:support id="supportTolerancia" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgTolerancia,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgTolerancia" value="#{registrarEscalaAldreteBean.msgTolerancia}" style="color:blue" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                  <t:message for="mnuTolerancia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value=" Eliminaci�n urinaria " styleClass="labelTextOblig" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuEliminacion" required="true" layout="pageDirection" immediate="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"
                                    value="#{registrarEscalaAldreteBean.aldreteObject.halnelimiurina}" valueChangeListener="#{registrarEscalaAldreteBean.setHalnelimiurina}">
                    <f:selectItems value="#{registrarEscalaAldreteBean.lstEliminacion}"/>
                    <a4j:support id="supportEliminacion" event="onclick" immediate="true" action="#{registrarEscalaAldreteBean.calcularEscalaAldrete}" reRender="msgEliminacion,panelCalcAldrete">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText id="msgEliminacion" value="#{registrarEscalaAldreteBean.msgEliminacion}" style="color:blue" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarEscalaAldreteBean.renderAmbulatorio}">
                  <t:message for="mnuEliminacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value=""/>
                <h:outputText value=""/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Calcular Escala" id="fieldCalcularEscala" styleClass="fieldset">
              <h:panelGrid style="text-align:left" columns="1" id="panelCalcAldrete" border="0" cellpadding="0" cellspacing="0" width="90%">
                <h:outputText value="#{registrarEscalaAldreteBean.numeroEscala}" styleClass="labelTextUnderLine2"/>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAldrete" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{registrarEscalaAldreteBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid style="text-align:left" columns="1" id="panelTotalAdmin" border="0" cellpadding="0" cellspacing="0" width="90%">
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
                <t:messages id="msgInformationAndErrorsAldrete" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
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
  <f:subview id="generarContLiq" rendered="#{registrarNotaEnfermeriaBean.generoReporte}">
    <f:subview id="generarReporteContLiq" rendered="#{registrarNotaEnfermeriaBean.generoReporte}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
                </script>
      </f:verbatim>
    </f:subview>
  </f:subview>
</h:panelGrid>