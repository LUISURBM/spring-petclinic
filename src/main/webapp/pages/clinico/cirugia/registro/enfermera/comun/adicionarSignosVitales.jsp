<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                   serverSideTabSwitch="false" activePanelTabVar="true"
                   width="100%" id="panelTabbedPaneFormulaHospitalizacion"
                   styleClass="tabbedPane" activeTabStyleClass="activeTab"
                   inactiveTabStyleClass="inactiveTab"
                   disabledTabStyleClass="disabledTab"
                   activeSubStyleClass="activeSub"
                   inactiveSubStyleClass="inactiveSub"
                   tabContentStyleClass="tabContent">
  <t:panelTab id="panelTabSignosVitales" label="Signos Vitales ">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="tableContentTabsSignosVitales"
                 styleClass="tabContainer">
      <s:fieldset legend="#{registrarSignosVitalesBean.legendServicio}" id="fieldCirugiasSignos"
                  styleClass="fieldset"> 
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelCirugiasSignos"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="#{registrarSignosVitalesBean.legendTablaServicio}"/>
          <h:outputText/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0"
                     rendered="#{not empty registrarSignosVitalesBean.lstCirugias}"
                     cellspacing="0" width="100%"
                     id="tableCirugiasProgramadasSignos"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{registrarSignosVitalesBean.dtCirugias}"
                         value="#{registrarSignosVitalesBean.lstCirugias}"
                         rows="20" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion"
                         id="dtCirugiasProgramadasSignos">
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
              <t:dataScroller id="scroll_1" for="dtCirugiasProgramadasSignos"
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
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
        .
      </s:fieldset>
      <s:fieldset legend="Historial Signos Vitales "
                  id="fieldLiquidosEliminacion" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%"
                     id="tableLiquidosEliminadosAnteriormenteSinDatos"
                     rendered="#{empty registrarSignosVitalesBean.lstHistorialSignosVitalesTomados}"
                     styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableLiquidosEliminadosAnteriormente"
                     rendered="#{not empty registrarSignosVitalesBean.lstHistorialSignosVitalesTomados}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{registrarSignosVitalesBean.lstHistorialSignosVitalesTomados}"
                         rows="15" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion"
                         id="dtHistorialLiquidosEliminados">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha y Hora Registro"/>
                </f:facet>
                <h:outputText value="#{item.hsvdhoraactivi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Presion Arterial"/>
                </f:facet>
                <h:outputText value="#{item.hsvnpresart1} / #{item.hsvnpresart2} mm Hg"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Frecuencia Cardiaca"/>
                </f:facet>
                <h:outputText value="#{item.hsvnfreccard} l.p.m"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Frecuencia Respiratoria"/>
                </f:facet>
                <h:outputText value="#{item.hsvnfrecresp}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Frecuencia Cardiaca"/>
                </f:facet>
                <h:outputText value="#{item.hsvnfreccard} l.p.m"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Temperatura"/>
                </f:facet>
                <h:outputText value="#{item.hsvatemperatu}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Saturaci�n"/>
                </f:facet>
                <h:outputText value="#{item.hsvnsatuoxihe}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Codigo Enfermera"/>
                </f:facet>
                <h:outputText value="#{item.hsvcoperador}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_9" for="dtHistorialLiquidosEliminados"
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
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      
      
      
            <a4j:commandLink action="#{registrarSignosVitalesBean.resetDatos}" immediate="true"
                       reRender="panelTabSignosVitales" title="Registrar Nuevo Signos Vitales">
        <t:graphicImage alt="Registrar Nuevos Signos Vitales" title="Registrar Nuevo Signos Vitales" border="0"
                        url="/comun/imagenes/nuevo.jpg"/>
      </a4j:commandLink>
      
      
      <s:fieldset legend="Registro de Signos Vitales" id="fieldSignosVitales"
                  styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelDatosExamen"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup id="panelTextHoraActual">
              <h:outputText value="Los signos vitales acaban de ser tomados?"
                            styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextFecha">
              <h:outputText value="Hace cuanto minutos tomo signos vitales "
                            styleClass="labelTextOblig"
                            rendered="#{registrarSignosVitalesBean.mostrarHoraActual}"/>
            </h:panelGroup>
            <h:outputText/>
            <h:panelGroup id="panelMenuHoraActual">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuHoraActual" required="false"
                                  immediate="true"
                                  value="#{registrarSignosVitalesBean.esHoraActual}"
                                  valueChangeListener="#{registrarSignosVitalesBean.setEsHoraActual}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSignosVitalesBean.lstOpciones}"/>
                  <a4j:support id="supportmnuHoraActual" event="onclick"
                               action="#{registrarSignosVitalesBean.ChangeEsHoraActual}"
                               reRender="panelTextFecha,panelCalendarAdministracion,itPanelMenuHora,itTextDosisSuministrada,itInputDosisSuministrada">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuHoraActual" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelCalendarAdministracion">
              <h:inputText id="minutosAdministracion" required="true"
                           maxlength="3" style="width:50px"
                           value="#{registrarSignosVitalesBean.tiempoAdministracion}"
                           rendered="#{registrarSignosVitalesBean.mostrarHoraActual}"/>
              <a4j:outputPanel ajaxRendered="true"
                               rendered="#{registrarSignosVitalesBean.mostrarHoraActual}">
                <t:message for="minutosAdministracion"
                           styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText/>
            <h:outputText value="Presion Arterial" styleClass="labelTextOblig"/>
            <h:outputText value="Frecuencia Cardiaca"
                          styleClass="labelTextOblig"/>
          <h:outputText value="Frecuencia Respiratoria"/>
            <h:panelGroup>
              <h:inputText id="itPresion" title="mm Hg" required="true"
                           immediate="true"
                           onkeydown="return blockEnter(event);"
                           value="#{registrarSignosVitalesBean.signo.hsvnpresart1}"
                           valueChangeListener="#{registrarSignosVitalesBean.setHsvnpresart1}"
                           style="width:30px" maxlength="3">
                <a4j:support id="supportPresion1" event="onchange"
                             immediate="true"
                             action="#{registrarSignosVitalesBean.ChangeMensajePresion1}"
                             reRender="msgPresion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText id="msgPresion"
                            value="#{registrarSignosVitalesBean.msgPresion}"
                            style="color:red"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="/"/>
              <h:inputText id="itPresion2" title="mm Hg" required="true"
                           onkeydown="return blockEnter(event);"
                           immediate="true"
                           value="#{registrarSignosVitalesBean.signo.hsvnpresart2}"
                           valueChangeListener="#{registrarSignosVitalesBean.setHsvnpresart2}"
                           style="width:30px" maxlength="3">
                <a4j:support id="supportPresion2" event="onchange"
                             immediate="true"
                             action="#{registrarSignosVitalesBean.ChangeMensajePresion2}"
                             reRender="msgPresion2">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText value="  mm Hg"/>
              <h:outputText id="msgPresion2"
                            value="#{registrarSignosVitalesBean.msgPresion2}"
                            style="color:red"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresion2" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itCardiaca" title="latidos por minuto"
                           onkeydown="return blockEnter(event);" required="true"
                           immediate="true"
                           value="#{registrarSignosVitalesBean.signo.hsvnfreccard}"
                           valueChangeListener="#{registrarSignosVitalesBean.setHsvnfreccard}"
                           style="width:30px" maxlength="3">
                <a4j:support id="supportCardiaca" event="onchange"
                             immediate="true"
                             action="#{registrarSignosVitalesBean.ChangeMensajeFrecCardiaca}"
                             reRender="msgCardiaca">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText id="msgCardiaca"
                            value="#{registrarSignosVitalesBean.msgFrecuenciaCardiaca}"
                            style="color:red"/>
              <h:outputText value="  l.p.m"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCardiaca" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          <h:panelGroup>
              <h:inputText id="itRespiratoria" title="latidos por minuto"
                           onkeydown="return blockEnter(event);" required="false"
                           immediate="true"
                           value="#{registrarSignosVitalesBean.signo.hsvnfrecresp}"
                           valueChangeListener="#{registrarSignosVitalesBean.setHsvnfrecresp}"
                           style="width:30px" maxlength="3">
                <a4j:support id="supportRespiratoria" event="onchange"
                             immediate="true"
                             action="#{registrarSignosVitalesBean.ChangeMensajeFrecRespiratoria}"
                             reRender="msgRespiratoria">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText id="msgRespiratoria"
                            value="#{registrarSignosVitalesBean.msgFrecuenciaRespiratoria}"
                            style="color:red"/>
              <h:outputText value="  l.p.m"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itRespiratoria" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Temperatura"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Saturaci�n"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:panelGroup>
              <h:inputText id="itTemperaura"
                           onkeydown="return blockEnter(event);"
                           immediate="true"
                           title="Temperatura en grados cent�grados"
                           value="#{registrarSignosVitalesBean.signo.hsvatemperatu}"
                           valueChangeListener="#{registrarSignosVitalesBean.setHsvatemperatu}"
                           style="width:50px" maxlength="5">
                <a4j:support id="supportTemperaturaFebril"
                             oncomplete="temperaturaJs()"
                             action="#{registrarSignosVitalesBean.ChangeMensajeTemperatura}"
                             reRender="msgTemperaturaFebril" event="onchange"
                             immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTemperaura" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText id="msgTemperaturaFebril"
                            value="#{registrarSignosVitalesBean.msgTemperatura}"
                            style="color:red"/>
              <h:outputText value="  �C"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itSaturacion" style="width:50px" immediate="true"
                           value="#{registrarSignosVitalesBean.signo.hsvnsatuoxihe}"
                           valueChangeListener="#{registrarSignosVitalesBean.setHsvnsatuoxihe}"
                           maxlength="3">
                <a4j:support id="supportSaturacion" oncomplete="temperaturaJs()"
                             action="#{registrarSignosVitalesBean.ChangeMensajeSaturacion}"
                             reRender="msgSaturacion" event="onchange"
                             immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText id="msgSaturacion"
                            value="#{registrarSignosVitalesBean.msgSaturacion}"
                            style="color:red"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTemperaura" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup></h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup></h:panelGroup>
          </h:panelGrid>
        </a4j:region>
      </s:fieldset>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                           action="#{registrarSignosVitalesBean.aceptar}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    <t:popup styleClass="popup" closePopupOnExitingElement="true"
             closePopupOnExitingPopup="true" displayAtDistanceX="20"
             displayAtDistanceY="1">
      <h:commandLink id="imprimirReporte" immediate="true"
                     action="#{registrarSignosVitalesBean.generarReporte}">
        <t:graphicImage alt="" border="0" url="/comun/imagenes/pdfIcon.png"/>
        <h:outputText value="Imprimir Signos Vitales"/>
      </h:commandLink>
      <f:facet name="popup">
        <h:panelGroup>
          <h:panelGrid columns="2" style="text-align:left;">
            <h:outputText value="IMPRIMIR SIGNOS VITALES"/>
          </h:panelGrid>
        </h:panelGroup>
      </f:facet>
      
     
      
    </t:popup>
    <f:subview id="generarSignos"
               rendered="#{registrarSignosVitalesBean.generoReporte}">
      <f:subview id="generarReporteSignos"
                 rendered="#{registrarSignosVitalesBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
                </script>
        </f:verbatim>
      </f:subview>
    </f:subview>
  </t:panelTab>
</t:panelTabbedPane>