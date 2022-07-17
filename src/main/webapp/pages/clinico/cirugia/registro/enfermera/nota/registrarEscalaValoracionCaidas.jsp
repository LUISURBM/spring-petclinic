<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoCirugiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoEnfermeriaTab"
               styleClass="tabContainer">
    <s:fieldset legend="Accesos Directos" id="accesosDirectos" styleClass="fieldset" rendered="#{!registrarEscalaValoracionCaidasBean.notaEnfeProce}">
      <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAccesosDirectos"
                   rowClasses="labelText,labelTextInfo">
        <h:panelGrid columns="1" id="notasEnfermeria">
          <h:outputText value="Notas Enfermeria"/>
          <h:commandLink id="visualizarNotasEnfermeria" action="#{menuEnfermeriaBean.registrarNotasEnfermeria}"
                         immediate="true">
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
          <h:commandLink id="visualizarMedicamentos" action="#{menuEnfermeriaBean.registrarMedicamentos}"
                         immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Vial-Pills.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="signosvitales">
          <f:facet name="header">
            <h:outputText value="Signos Vitales"/>
          </f:facet>
          <h:commandLink id="visualizarSignosVitales" action="#{menuEnfermeriaBean.registrarSignosVitales}"
                         immediate="true">
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
          <h:commandLink id="visualizarAldrete" action="#{menuEnfermeriaBean.registrarAldrete}"
                         rendered="#{menuEnfermeriaBean.renderAldrete}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/BandAid.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="bromage" rendered="#{menuEnfermeriaBean.renderBromage}">
          <f:facet name="header">
            <h:outputText value="Bromage" rendered="#{menuEnfermeriaBean.renderBromage}"/>
          </f:facet>
          <h:commandLink id="visualizarBromage" action="#{menuEnfermeriaBean.registrarBromage}"
                         rendered="#{menuEnfermeriaBean.renderBromage}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/BandAid.png"/>
          </h:commandLink>
        </h:panelGrid>
      </h:panelGrid>
    </s:fieldset>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridNotaEnfermeriaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAldrete" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAldret" label="Escala Valoraci�n Ca�das">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAldrete"
                       styleClass="tabContainer">
            <s:fieldset legend="#{registrarEscalaValoracionCaidasBean.legendServicio}" id="fieldCirugiasAldrete" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAldrete"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="#{registrarEscalaValoracionCaidasBean.legendTablaServicio}"/>
                <h:outputText/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           rendered="#{not empty registrarEscalaValoracionCaidasBean.lstCirugias}" cellspacing="0"
                           width="100%" id="tableCirugiasProgramadasAldrete" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{registrarEscalaValoracionCaidasBean.dtCirugias}"
                               value="#{registrarEscalaValoracionCaidasBean.lstCirugias}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtCirugiasProgramadasAldrete">
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
            <s:fieldset legend="Datos Escala Valoraci�n Ca�das" id="fieldAldrete" styleClass="fieldset">
              <s:fieldset legend="" id="fieldAreaEscalaG1" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                             id="panelAreaEscalaG1" rowClasses="labelText,labelTextInfo">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelCaidasPrevias" rowClasses="standardTable_Row4,standardTable_Row4"
                               style="border-color:#3f3e23;">
                    <h:outputText value="Ca�das previas" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectOneRadio style="border-style:none;" immediate="true"
                                              id="mnuAreaCaidasPrevias"
                                              value="#{registrarEscalaValoracionCaidasBean.chescvalcai.hevccaidprev}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasBean.setHevccaidprev}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasBean.lstCaidasPrevias}"/>
                          <a4j:support id="supportmnuAreaCaidasPrevias" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaCaidasPrevias" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelAreaEstadoMental" rowClasses="standardTable_Row3,standardTable_Row3"
                               style="border-colo:#3f3e23;">
                    <h:outputText value="Estado Mental" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectOneRadio required="true" style="border-style:none;" immediate="true"
                                              id="mnuAreaEstadoMental"
                                              value="#{registrarEscalaValoracionCaidasBean.chescvalcai.hevccestament}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasBean.setHevccestament}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasBean.lstEstadoMental}"/>
                          <a4j:support id="supportmnuAreaEstadoMental" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaEstadoMental" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGrid>
              </s:fieldset>
              <s:fieldset legend="" id="fieldAreaEscalaG2" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                             id="panelAreaEscalaG2" rowClasses="labelText,labelTextInfo">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelAreaDeficitSensorial" rowClasses="standardTable_Row3,standardTable_Row3"
                               style="border-colo:#3f3e23;">
                    <h:outputText value="D�ficit Sensorial" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                              id="mnuAreaDeficitSensorial"
                                              value="#{registrarEscalaValoracionCaidasBean.lstDeficitSensorialSelect}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasBean.setDeficitSensorialSelect}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasBean.lstDeficitSensorial}"/>
                          <a4j:support id="supportmnuAreaDeficitSensorial" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectManyCheckbox>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaDeficitSensorial" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelDeambulacion" rowClasses="standardTable_Row4,standardTable_Row4"
                               style="border-color:#3f3e23;">
                    <h:outputText value="Deambulaci�n" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                              id="mnuAreaDeambulacion"
                                              value="#{registrarEscalaValoracionCaidasBean.lstDeambulacionSelect}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasBean.setDeambulacionSelect}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasBean.lstDeambulacion}"/>
                          <a4j:support id="supportmnuAreaDeambulacion" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectManyCheckbox>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaDeambulacion" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGrid>
              </s:fieldset>
              <s:fieldset legend="" id="fieldAreaEscalaG3" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                             id="panelAreaEscalaG3" rowClasses="labelText,labelTextInfo">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                               id="panelMedicamentos" rowClasses="standardTable_Row4,standardTable_Row4"
                               style="border-color:#3f3e23;">
                    <h:outputText value="Medicamentos" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                              id="mnuAreaMedicamentos"
                                              value="#{registrarEscalaValoracionCaidasBean.lstMedicamentosSelect}"
                                              valueChangeListener="#{registrarEscalaValoracionCaidasBean.setMedicamentosSelect}"
                                              layout="pageDirection">
                          <f:selectItems value="#{registrarEscalaValoracionCaidasBean.lstMedicamentos}"/>
                          <a4j:support id="supportmnuAreaMedicamentos" event="onclick" immediate="true"
                                       action="#{registrarEscalaValoracionCaidasBean.calcularEscalaValoracionCaidas}"
                                       reRender="panelPuntos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:selectManyCheckbox>
                        <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAreaMedicamentos" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                      </a4j:region>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGrid>
              </s:fieldset>
              <h:panelGrid style="text-align:left" columns="1" id="panelPuntos" border="0" cellpadding="0"
                           cellspacing="0" width="90%">
                <h:outputText value=" "/>
                <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgPuntos}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgRiesgo}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgRiesgo1}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgRiesgo2}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgRiesgo3}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgRiesgo4}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgRiesgo5}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                 <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgRiesgo6}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
                <h:outputText value=" "/>
                 <h:panelGroup>
                  <h:outputText value="#{registrarEscalaValoracionCaidasBean.msgRiesgo7}"
                                styleClass="labelTextBlueUnderLine"/>
                </h:panelGroup>
                
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonEscala"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Agregar Seguimiento" styleClass="btn btn btn-success"
                                   action="#{registrarEscalaValoracionCaidasBean.agregarEscala}">
                    <a4j:support event="onclick" status="statusButton" reRender="fieldListaEscValCai"/>
                  </h:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Seguimiento Escala Valoraci�n Ca�das" id="fieldListaEscValCai" styleClass="fieldset">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="tableListaEscValCai" styleClass="tabContainer">
                    <a4j:region renderRegionOnly="false">
                      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="4"
                                   value="#{registrarEscalaValoracionCaidasBean.listaEscalaValoracionCaida}" rows="15"
                                   styleClass="standard_table"
                                   binding="#{registrarEscalaValoracionCaidasBean.dtSeguimiento}"
                                   rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                   rendered="#{not empty registrarEscalaValoracionCaidasBean.listaEscalaValoracionCaida}"
                                   id="dtEscala">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Caidas Previas"/>
                          </f:facet>
                          <h:outputText value="#{item.caidasPrevias}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Medicamentos"/>
                          </f:facet>
                          <h:outputText value="#{item.medicamentos}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="D�ficit sensorial"/>
                          </f:facet>
                          <h:outputText value="#{item.deficitSensorial}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Estado Mental"/>
                          </f:facet>
                          <h:outputText value="#{item.estadoMental}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Deambulaci�n"/>
                          </f:facet>
                          <h:outputText value="#{item.deambulacion}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Puntos"/>
                          </f:facet>
                          <h:outputText value="#{item.hevccpuntos}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                          <a4j:commandLink id="eliminarEscala"
                                           action="#{registrarEscalaValoracionCaidasBean.eliminarEscala}"
                                           rendered="#{item.editable}"
                                           onclick="if (!confirm(\'�Esta seguro de Eliminar? \')) return false"
                                           reRender="tableListaEscValCai">
                            <t:graphicImage id="imageEliminar" border="0" url="/comun/imagenes/eliminarObj.gif"
                                            alt="Eliminar"/>
                          </a4j:commandLink>
                        </h:column>
                      </h:dataTable>
                    </a4j:region>
                </h:panelGrid>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAldrete"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <a4j:commandButton value="Guardar" styleClass="btn btn btn-success" reRender="fieldListaEscValCai"
                                 action="#{registrarEscalaValoracionCaidasBean.aceptar}" >
                  <a4j:support event="onclick" status="statusButton" />
                </a4j:commandButton>
                </a4j:region>
              </h:panelGroup>
            </h:panelGrid>
            </s:fieldset>
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
          <h:commandLink action="irListaNotasEnfermeria" immediate="true" rendered="#{!registrarEscalaValoracionCaidasBean.notaEnfeProce}">
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