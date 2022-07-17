<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formRegistrarEpicrisis">
  <a4j:region id="regionRegistrarEpicrisis" renderRegionOnly="false">
    <a4j:status for="regionRegistrarEpicrisis">
      <f:facet name="start">
        <t:div id="chargingRegistrarEpicrisis" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid id="verHistoriaClinica" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentInfoLab"></h:panelGrid>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarEpicrisisTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneRegistrarEpicrisis" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" selectedIndex="#{registrarEpicrisisBean.selectedIndex}"
                         inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabRegistrarEpicrisis" label="Registrar Epicrisis"
                    disabled="#{registrarEpicrisisBean.mostrarCie10}">
          <h:panelGrid id="panelDatosListaDetalleCirugiasEgresoIngreso" columns="1" border="0" cellpadding="0"
                       cellspacing="0" width="100%" styleClass="tabContainer">
              <s:fieldset legend="Datos de Identificación" id="fieldUsuario" styleClass="fieldset_dataTable">
                      <h:panelGrid columns="4"  border="0" cellpadding="0" cellspacing="0" width="100%" rowClasses="labelText,labelTextInfo"
                           id="pgUsuario">
                              <h:outputText value="Tipo Identificación"/>
                                <h:outputText value="Número Identificación"/>
                                  <h:outputText value=""/>
                                  <h:outputText value=""/>
                                  <h:outputText value="#{registrarEpicrisisBean.usuario.husetipoiden}"/>
                                  <h:outputText value="#{registrarEpicrisisBean.usuario.husanumeiden}"/>
                                  <h:outputText value=""/>
                                  <h:outputText value=""/>
                                  <h:outputText value="Primer Nombre"/>
                                  <h:outputText value="Segundo Nombre"/>
                                  <h:outputText value="Primer Apellido"/>
                                  <h:outputText value="Segundo Apellido"/>
                                     <h:outputText value="#{registrarEpicrisisBean.usuario.huscprimernomb}"/>
                                     <h:outputText value="#{registrarEpicrisisBean.usuario.huscsegundnomb}"/>
                                     <h:outputText value="#{registrarEpicrisisBean.usuario.huscprimerapel}"/>
                                    <h:outputText value="#{registrarEpicrisisBean.usuario.huscsegundapel}"/>
                                  <h:outputText value="Edad"/>
                                  <h:outputText value="Sexo"/>
                                  <h:outputText value=""/>
                                  <h:outputText value=""/>
                                   <h:outputText value="#{registrarEpicrisisBean.usuario.edad}"/>
                                     <h:outputText value="#{registrarEpicrisisBean.sexo}"/>
                                      <h:outputText value=""/>
                                  <h:outputText value=""/>
                                  </h:panelGrid>
                                  </s:fieldset>
                           
            <s:fieldset legend="Cirugias Ingreso" id="fieldSetDetalleCirugiasIngreso" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarDetalleIngreso"
                           rendered="#{empty registrarEpicrisisBean.lstCirugiasIngreso}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentTabsConsultarDetalleCirugiaIngreso"
                           rendered="#{not empty registrarEpicrisisBean.lstCirugiasIngreso}" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               value="#{registrarEpicrisisBean.lstCirugiasIngreso}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtDetalleIngreso">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Codigo"/>
                      </f:facet>
                      <h:outputText value="#{item.csvccodigo}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Cirugia"/>
                      </f:facet>
                      <h:outputText value="#{item.csvcnombre}"/>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_DetalleIngreso" for="dtDetalleIngreso" fastStep="10"
                                    pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                    paginator="true" immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage url="/comun/imagenes/primero.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage url="/comun/imagenes/anterior.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage url="/comun/imagenes/adelante.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage url="/comun/imagenes/atras.gif" border="0" alt=""/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
           
            
                <s:fieldset legend="Servicio de Ingreso" id="fieldSetServIngreso" styleClass="fieldset_dataTable">
                      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="pgServiciosIngreso">
                               <h:outputText value="Servicio de Ingreso" styleClass="labelTextOblig"/>
                                <h:outputText value="Fecha y hora de Ingreso" styleClass="labelTextOblig"/>
                                <h:panelGroup>
                                    <h:selectOneMenu id="mnuServicioIngreso" value="#{registrarEpicrisisBean.epicrisis.hepcserviingre}">
                                    <f:selectItems value="#{registrarEpicrisisBean.lstServicioIngreso}"/>
                                    </h:selectOneMenu>
                                    <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="mnuServicioIngreso" styleClass="errorMessage"/>
                                    </a4j:outputPanel>
                            </h:panelGroup>
                              <h:outputText value="#{registrarEpicrisisBean.epicrisis.hepdfechaingre}">
                <f:convertDateTime pattern="dd/MM/yyyy hh:mm"/>
              </h:outputText>
                        </h:panelGrid>
                </s:fieldset>
                 <s:fieldset legend="Servicio de Egreso" id="fieldSetServEgreso" styleClass="fieldset_dataTable">
                      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="pgServiciosEgreso">
                               <h:outputText value="Servicio de Egreso" styleClass="labelTextOblig"/>
                                <h:outputText value="Fecha y hora de Egreso" styleClass="labelTextOblig"/>

                              <h:outputText value="#{registrarEpicrisisBean.epicrisis.hepcserviegres}"/> 
                              <h:outputText value="#{registrarEpicrisisBean.epicrisis.hepdfechaegres}">
                <f:convertDateTime pattern="dd/MM/yyyy hh:mm"/>
              </h:outputText>
                        </h:panelGrid>
                </s:fieldset>
          </h:panelGrid>
          <s:fieldset legend="Datos del Ingreso" id="fieldSetEpicrisis" styleClass="fieldset">
            <t:htmlTag value="br"/>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridRegistrarEpicrisis2" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Motivo de Consulta" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itMotivoConsulta" required="true" immediate="true" value="#{registrarEpicrisisBean.epicrisis.hepcmotivocons}"
                                 style="width:800px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itMotivoConsulta" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Enfermedad Actual" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itEnfermedadActual" immediate="true" required="true" value="#{registrarEpicrisisBean.epicrisis.hepcenfeactual}"
                                 style="width:800px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itEnfermedadActual" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Antecedentes" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itAntecedentes" immediate="true" required="true" value="#{registrarEpicrisisBean.epicrisis.hepcantecedent}"
                                 style="width:800px" rows="4" />
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itAntecedentes" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Revisión por Sistemas" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itRevisionSistemas" immediate="true" required="true" value="#{registrarEpicrisisBean.epicrisis.hepcrevisistem}"
                                 style="width:800px" rows="4" />
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itRevisionSistemas" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Hallazgos al Examen Fisico" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itHallazgos" required="true" immediate="true" value="#{registrarEpicrisisBean.epicrisis.hepchallaexafi}"
                                 style="width:800px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itHallazgos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Diagnóstico de Ingreso " id="fieldSetEpicrisisImpresion" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridImpreisonEpicrisis" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Diagnostico Presuntivo" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoPrincipalI}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagPrin" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                             immediate="true" binding="#{registrarEpicrisisBean.itDiagPresI}" required="true"
                             value="#{registrarEpicrisisBean.epicrisis.hepcdiagingnpresu}"
                             valueChangeListener="#{registrarEpicrisisBean.setHepcdiagingnpresu}" style="width:50px"
                             maxlength="4">
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportitDiagPrin" event="onchange" ignoreDupResponses="true" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoPrincipalI}"
                               reRender="panelDiagnostico1Cirugia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagPrin" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnostico1Cirugia">
                  <h:outputText value=" #{registrarEpicrisisBean.diagnosticoPrincipalIngreso}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
              <h:outputText value="Diagnóstico Relacionado Uno(1)" />
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoRelacionadoUI}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagnosticoRelacIU" styleClass="textmayuscula"
                             onkeydown="return blockEnter(event);" immediate="true" 
                             binding="#{registrarEpicrisisBean.itDiagrelacUI}"
                             value="#{registrarEpicrisisBean.epicrisis.hepcdiagingnrelacu}"
                             valueChangeListener="#{registrarEpicrisisBean.setHepcdiagingrelacu}" style="width:50px"
                             maxlength="4">
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportDiagnostico1" event="onchange" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoRelacionadoUI}"
                               reRender="panelDiagnosticoPosteriorDescripcion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagnosticoRelacIU" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                             id="panelDiagnosticoPosteriorDescripcion">
                  <h:outputText value="#{registrarEpicrisisBean.diagnosticoRelacionadoUIngreso}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
              <h:outputText value="Diagnostico Relacionado Dos (2)" />
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoRelacionadoDI}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagnosticoRelacionadoI2" styleClass="textmayuscula"
                             onkeydown="return blockEnter(event);" immediate="true" 
                               binding="#{registrarEpicrisisBean.itDiagrelacDI}"
                              value="#{registrarEpicrisisBean.epicrisis.hepcdiagingrelacd}"
                              valueChangeListener="#{registrarEpicrisisBean.setHepcdiagingrelacd}" style="width:50px"
                             maxlength="4">
                            
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportDiagnosticoRelacionado2" event="onchange" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoRelacionadoDI}"
                               reRender="panelDiagnosticoRelacionado">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagnosticoRelacionadoI2" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado">
                  <h:outputText value="#{registrarEpicrisisBean.diagnosticoRelacionadoDIngreso}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
               <h:outputText value="Diagnostico Relacionado Tres (3)"/>
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoRelacionadoTI}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagnosticoRelacionado3" styleClass="textmayuscula"
                             onkeydown="return blockEnter(event);" immediate="true" 
                             binding="#{registrarEpicrisisBean.itDiagrelacTI}"
                             value="#{registrarEpicrisisBean.epicrisis.hepcdiagingrelact}"
                             valueChangeListener="#{registrarEpicrisisBean.setHepcdiagingrelact}" style="width:50px"
                             maxlength="4">
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportDiagnosticoRelacionado3" event="onchange" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoRelacionadoTI}"
                               reRender="panelDiagnostico3">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagnosticoRelacionado3" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnostico3">
                  <h:outputText value="  #{registrarEpicrisisBean.diagnosticoRelacionadoTIngreso}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
              
            </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGriEvolucionEpicrisis" rowClasses="labelText,labelTextInfo">
             <h:outputText value="Conducta" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itConducta" immediate="true" required="true" value="#{registrarEpicrisisBean.epicrisis.hepcconducta}"
                                 style="width:800px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itConducta" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              </h:panelGrid>
            
          </s:fieldset>
          <s:fieldset legend="Datos de la Evolución" id="fieldSetEpicrisisEvolucion" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridEvolucionEpicrisis" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cambios en el estado del paciente" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itEvo" required="true" immediate="true" value="#{registrarEpicrisisBean.epicrisis.hepcevolucion}"
                                 style="width:800px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itEvo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Interpretación de resultados de procedimientos diagnóstico" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itIntRes" required="true" immediate="true" value="#{registrarEpicrisisBean.epicrisis.hepcintres}"
                                 style="width:800px">
                                 <f:validateLength maximum="500"/>
                                 </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itIntRes" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Justificación de indicaciones terapéuticas (si aplica)"/>
              <h:panelGroup>
                <h:inputTextarea id="itIndTerap" immediate="true" value="#{registrarEpicrisisBean.epicrisis.hepcindterap}"
                                 style="width:800px">
                                 <f:validateLength maximum="500"/>
                                 </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itIndTerap" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            
            </h:panelGrid>
          </s:fieldset>
             <s:fieldset legend="Diagnóstico de Egreso " id="fieldSetEpicrisisDiagEgreso" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridsDiagEgreso" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Diagnostico Presuntivo" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoPrincipalE}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagEgresPres" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                             immediate="true" binding="#{registrarEpicrisisBean.itDiagPresE}" required="true"
                             value="#{registrarEpicrisisBean.epicrisis.hepcdiagegrpresu}"
                             valueChangeListener="#{registrarEpicrisisBean.setHepcdiagegrnpresu}" style="width:50px"
                             maxlength="4">
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportitDiagPres" event="onchange" ignoreDupResponses="true" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoPrincipalE}"
                               reRender="panelDiagnosticoEgresoPres">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagEgresPres" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoEgresoPres">
                  <h:outputText value=" #{registrarEpicrisisBean.diagnosticoPrincipalEgreso}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
              <h:outputText value="Diagnostico Confirmado" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoConfirmado}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagEgresConf" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                             immediate="true" binding="#{registrarEpicrisisBean.itDiagconf}" required="true"
                             value="#{registrarEpicrisisBean.epicrisis.hepcdiagnconfi}"
                             valueChangeListener="#{registrarEpicrisisBean.setHepcdiagnconfi}" style="width:50px"
                             maxlength="4">
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportitDiagConf" event="onchange" ignoreDupResponses="true" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoConfirmado}"
                               reRender="panelDiagnosticoEgresoConf">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagPrin" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoEgresoConf">
                  <h:outputText value=" #{registrarEpicrisisBean.diagnosticoConfirmado}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
              <h:outputText value="Diagnóstico Relacionado Uno(1)" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoRelacionadoUE}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagnosticoEgreso1" styleClass="textmayuscula"
                             onkeydown="return blockEnter(event);" immediate="true" required="true"
                             binding="#{registrarEpicrisisBean.itDiagrelacUE}"
                             value="#{registrarEpicrisisBean.epicrisis.hepcdiagegrrelacu}"
                             valueChangeListener="#{registrarEpicrisisBean.setHepcdiagegrrelacu}" style="width:50px"
                             maxlength="4">
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportDiagnosticoConfirmado" event="onchange" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoRelacionadoUE}"
                               reRender="panelDiagnosticoEgresUno">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagnosticoEgreso1" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                             id="panelDiagnosticoEgresUno">
                  <h:outputText value="#{registrarEpicrisisBean.diagnosticoRelacionadoUEgreso}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
              <h:outputText value="Diagnostico Relacionado Dos (2)" />
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoRelacionadoDE}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagnosticoRelacionadoEgresDos" styleClass="textmayuscula"
                             onkeydown="return blockEnter(event);" immediate="true"
                               binding="#{registrarEpicrisisBean.itDiagrelacDE}"
                             value="#{registrarEpicrisisBean.epicrisis.hepcdiagegrrelacd}"
                              valueChangeListener="#{registrarEpicrisisBean.setHepcdiagegrrelacd}" style="width:50px"
                             maxlength="4">
                            
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportDiagnosticoRelacionadoEgresDos" event="onchange" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoRelacionadoDE}"
                               reRender="panelDiagnosticoEgresDos">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagnosticoRelacionadoEgresDos" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoEgresDos">
                  <h:outputText value="#{registrarEpicrisisBean.diagnosticoRelacionadoDEgreso}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
               <h:outputText value="Diagnostico Relacionado Tres (3)" />
              <h:outputText/>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{registrarEpicrisisBean.mostrarDiagnosticoRelacionadoTE}"
                                 reRender="panelGridRegistrarEpicrisisTab" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itDiagnosticoRelacionadoEgresTres" styleClass="textmayuscula"
                             onkeydown="return blockEnter(event);" immediate="true"
                             binding="#{registrarEpicrisisBean.itDiagrelacTE}"
                             value="#{registrarEpicrisisBean.epicrisis.hepcdiagegrrelact}"
                             valueChangeListener="#{registrarEpicrisisBean.setHepcdiagegrrelact}" style="width:50px"
                             maxlength="4">
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportDiagnosticoRelacionadoEgresTres" event="onchange" immediate="true"
                               action="#{registrarEpicrisisBean.changeDiagnosticoRelacionadoUTE}"
                               reRender="panelDiagnosticoEgresTres">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagnosticoRelacionadoEgresTres" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoEgresTres">
                  <h:outputText value="#{registrarEpicrisisBean.diagnosticoRelacionadoTEgreso}" styleClass="buscador"/>
                </h:panelGrid>
              </h:panelGrid>
              <h:outputText/>
              
            </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGriEvolucionEpicris" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Condiciones del Paciente al Egreso" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itCondicionesEgreso" immediate="true" required="true" value="#{registrarEpicrisisBean.epicrisis.hepccondegres}"
                                 style="width:800px">
                                   <f:validateLength maximum="500"/>
                                   </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCondicionesEgreso" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
               <h:outputText value="Plan de manejo ambulatorio" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:inputTextarea id="itPlanAmbulatorio" immediate="true" required="true" value="#{registrarEpicrisisBean.epicrisis.hepcplaman}"
                                 style="width:800px">
                                 <f:validateLength maximum="500"/>
                                 </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPlanAmbulatorio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              </h:panelGrid>
            
          </s:fieldset>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="20%" rowClasses="labelTextInfo,labelTextInfo">
            <h:outputText value="NOMBRE DEL MÉDICO"/>
            <h:outputText value="#{registrarEpicrisisBean.profesionalAct.cpfcnombre}"/>
              <h:outputText value="REGISTRO MÉDICO"/>
            <h:outputText value="#{registrarEpicrisisBean.profesionalAct.cpfcregmedic}"/>
             <h:outputText value="FIRMA"/>
            <h:outputText value=""/>
          </h:panelGrid>
          
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelBotonesRegistrarEpicrisis" columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Guardar"
                               onclick="if (!confirm(\'¿Realmente desea Registrar la Epicrisis \')) return false"
                               styleClass="btn btn btn-success" action="#{registrarEpicrisisBean.RegistrarEpicrisis}"/>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelBuscador" label="Buscar Diagnosticos" rendered="#{registrarEpicrisisBean.mostrarCie10}">
          <a4j:region id="regionCie10" renderRegionOnly="false">
            <a4j:status for="regionCie10">
              <f:facet name="start">
                <t:div id="chargingCie10" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <s:fieldset legend="Cie10" id="fieldSetCie10" styleClass="fieldset">
              <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp" flush="true"/>
              <h:panelGrid id="panelGridCie10Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
                <t:htmlTag value="br"/>
                <h:panelGroup id="panelGroupCie10Botones1">
                  <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     action="#{registrarEpicrisisBean.aceptarDiagnostico}"
                                     reRender="formRegistrarEpicrisis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionRegistrarEpicrisisMsg" ajaxRendered="true">
            <t:messages id="msgInformationRegistrarEpicrisisMsg" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
  </a4j:region>
</a4j:form>