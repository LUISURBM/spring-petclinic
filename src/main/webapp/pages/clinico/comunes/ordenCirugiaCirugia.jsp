<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridOrdendeCirugiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneOrdenDeCirugia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" selectedIndex="#{ordenCirugiaUsuarioBean.selectedIndex}"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabOrdenCirugia" label="Cirug�as y procedimientos"
                rendered="#{!ordenCirugiaUsuarioBean.mostrarCirugias}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridOrdenCirugia"
                   styleClass="tabContainer">
        <s:fieldset legend="Cirujano" id="fieldCirugias" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugias"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Intervenci�n(es) Propuesta(s)" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta">
              <a4j:commandLink value="" immediate="true" title="Seleccionar Cirugias"
                               rendered="#{!ordenCirugiaUsuarioBean.modoconsulta}"
                               action="#{ordenCirugiaUsuarioBean.consultarCirugias}"
                               reRender="panelGridOrdendeCirugiaTab" id="idButt">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="idButt" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty ordenCirugiaUsuarioBean.lstExamenesCirugias}" cellspacing="0" width="100%"
                       id="tableContentTabsBucar" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           binding="#{ordenCirugiaUsuarioBean.dtServicios}"
                           value="#{ordenCirugiaUsuarioBean.lstExamenesCirugias}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtCirugia">
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
                <h:column rendered="#{!ordenCirugiaUsuarioBean.modoconsulta}">
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="aceptarCirugias" immediate="true"
                                 action="#{ordenCirugiaUsuarioBean.eliminarCirugia}">
                    <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtCirugia" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif" border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif" border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif" border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
                  </f:facet>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
          <h:panelGrid columns="3" border="0" cellpadding="0"
                       rendered="#{ordenCirugiaUsuarioBean.esValoracionPreanestesica}" cellspacing="0" width="100%"
                       id="panelInformacionPreanestesia" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Anestesia General"/>
            <h:outputText value="Anestesia Regional"/>
            <h:outputText value="Anestesia Local Controlada"/>
            <h:panelGroup>
              <h:selectOneRadio id="mnuAnestesiaGeneral" onkeydown="return blockEnter(event);"
                                disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                value="#{ordenCirugiaUsuarioBean.orden.hoccanestgener}">
                <f:selectItems value="#{ordenCirugiaUsuarioBean.lstPreferenciaAnestesia}"/>
              </h:selectOneRadio>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneRadio id="mnuAnestesiaRegional" onkeydown="return blockEnter(event);"
                                disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                value="#{ordenCirugiaUsuarioBean.orden.hoccanestregio}">
                <f:selectItems value="#{ordenCirugiaUsuarioBean.lstPreferenciaAnestesia}"/>
              </h:selectOneRadio>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneRadio id="mnuAnestesiaLocal" onkeydown="return blockEnter(event);"
                                disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                value="#{ordenCirugiaUsuarioBean.orden.hoccanestlocal}">
                <f:selectItems value="#{ordenCirugiaUsuarioBean.lstPreferenciaAnestesia}"/>
              </h:selectOneRadio>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelObservacionesCirugias" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Observaciones" styleClass="labelTextOblig"/>
            <h:panelGroup>
                <h:outputText value = "�Se retira DIU con la cirug�a?" rendered="#{ordenCirugiaUsuarioBean.renderDiu}"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputTextarea id="textObservaciones" required="true" immediate="true"
                               onkeydown="return blockEnter(event);" disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                               value="#{ordenCirugiaUsuarioBean.orden.hoccobservacio}" style="width:500px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textObservaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGrid columns="2">
                <h:selectOneRadio id="mnuRetiraDiu" required="true"
                                  onkeydown="return blockEnter(event);"
                                  rendered="#{ordenCirugiaUsuarioBean.renderDiu}"
                                  disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                  value="#{ordenCirugiaUsuarioBean.orden.hoccretirdiu}">
                  <f:selectItems value="#{ordenCirugiaUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRetiraDiu" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            <h:panelGroup>
              <h:outputText value="Programar Cirugia" rendered="#{ordenCirugiaUsuarioBean.esValoracionPreanestesica}"/>
            </h:panelGroup>
            <h:panelGroup id="panelOutputRazones">
              <h:outputText value="Razones por las cuales no se programa la cirug�a"
                            rendered="#{ordenCirugiaUsuarioBean.mostrarRazones}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuProgramarCirugia" immediate="true" onkeydown="return blockEnter(event);"
                                  rendered="#{ordenCirugiaUsuarioBean.esValoracionPreanestesica}"
                                  disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                  value="#{ordenCirugiaUsuarioBean.orden.hoccprogrcirug}"
                                  valueChangeListener="#{ordenCirugiaUsuarioBean.setHoccprogrcirug}">
                  <f:selectItems value="#{ordenCirugiaUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportmnuProgramarCirugia" event="onclick" immediate="true"
                               action="#{ordenCirugiaUsuarioBean.changeProgramarCirugia}"
                               reRender="panelOutputRazones,panelInputRazones,panelMenuAceptaProce,panelOutputAceptaProce,outputLugarProcedimiento,inputLugarProcedimiento,tableFechasCirugia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true" rendered="#{ordenCirugiaUsuarioBean.esValoracionPreanestesica}">
                  <t:message for="mnuProgramarCirugia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelInputRazones">
              <h:inputTextarea id="itRazonCirugia" required="true" style="width:250px"
                               onkeydown="return blockEnter(event);" disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                               rendered="#{ordenCirugiaUsuarioBean.mostrarRazones}"
                               value="#{ordenCirugiaUsuarioBean.orden.hoccrazoncirug}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itRazonCirugia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAceptaCirugias"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup id="panelOutputAceptaProce">
              <h:outputText value="La Paciente acepta y entiende el procedimiento" styleClass="labelTextOblig"
                            rendered="#{!ordenCirugiaUsuarioBean.esValoracionPreanestesica || ordenCirugiaUsuarioBean.mostrarAcepta}"/>
            </h:panelGroup>
            <h:panelGroup id="outputLugarProcedimiento">
              <h:outputText value="Lugar de realizaci�n del procedimiento" styleClass="labelTextOblig"
                            rendered="#{ordenCirugiaUsuarioBean.mostrarLugar}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" id="panelMenuAceptaProce">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuAceptaProcedimiento" onkeydown="return blockEnter(event);"
                                  rendered="#{!ordenCirugiaUsuarioBean.esValoracionPreanestesica || ordenCirugiaUsuarioBean.mostrarAcepta}"
                                  immediate="true" disabled="#{ordenCirugiaUsuarioBean.modoconsulta}" required="true"
                                  binding="#{ordenCirugiaUsuarioBean.mnuAcepta}"
                                  value="#{ordenCirugiaUsuarioBean.orden.hoccpaciacepta}"
                                  valueChangeListener="#{ordenCirugiaUsuarioBean.setHoccpaciacepta}">
                  <f:selectItems value="#{ordenCirugiaUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportmnuAceptaProcedimiento" event="onclick"
                               action="#{ordenCirugiaUsuarioBean.changeAcepta}"
                               reRender="outputLugarProcedimiento,inputLugarProcedimiento,tableFechasCirugia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAceptaProcedimiento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </a4j:region>
            <h:panelGroup id="inputLugarProcedimiento">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="2">
                  <h:selectOneMenu id="mnuLugarProcedimiento" immediate="true" onkeydown="return blockEnter(event);"
                                   disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                   binding="#{ordenCirugiaUsuarioBean.mnuLugar}"
                                   rendered="#{ordenCirugiaUsuarioBean.mostrarLugar}" required="true"
                                   value="#{ordenCirugiaUsuarioBean.orden.hocclugarinter}"
                                   valueChangeListener="#{ordenCirugiaUsuarioBean.setHocclugarinter}">
                    <f:selectItems value="#{ordenCirugiaUsuarioBean.lstLugar}"/>
                    <a4j:support id="supportmnuLugarProcedimiento" event="onchange" immediate="true"
                                 action="#{ordenCirugiaUsuarioBean.changeLugar}" reRender="tableFechasCirugia">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuLugarProcedimiento" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
              </a4j:region>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableFechasCirugia">
          <s:fieldset legend="Fechas Cirugia" id="fieldFechaCirugia" styleClass="fieldset"
                      rendered="#{ordenCirugiaUsuarioBean.mostrarProgramacion && !ordenCirugiaUsuarioBean.renderVasectomia && !ordenCirugiaUsuarioBean.renderDiu}">
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosCirugia"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tiempo Qx  " styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:outputText/>
              <h:panelGrid columns="3">
                <h:selectOneMenu id="mnuTiempo" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{ordenCirugiaUsuarioBean.mnuTiempo}"
                                 value="#{ordenCirugiaUsuarioBean.tiempoSelect}" required="true"
                                 disabled="#{ordenCirugiaUsuarioBean.modoconsulta}">
                  <f:selectItems value="#{ordenCirugiaUsuarioBean.lstDuracion}"/>
                </h:selectOneMenu>
                <h:outputText value=" Minutos"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTiempo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:outputText/>
              <h:outputText/>
              <h:outputText value="Anestesia Solicitada " styleClass="labelTextOblig"/>
              <h:outputText value="Ayudantia" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGroup>
                <h:selectOneMenu id="mnuAnestesia" required="true" immediate="true"
                                 onkeydown="return blockEnter(event);" binding="#{ordenCirugiaUsuarioBean.mnuAnestesia}"
                                 disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                 value="#{ordenCirugiaUsuarioBean.orden.hocctipoaneste}">
                  <f:selectItems value="#{ordenCirugiaUsuarioBean.lstTipoAnestesia}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAnestesia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGrid columns="2">
                <h:selectOneRadio id="mnuAyudantia" required="true" immediate="true"
                                  onkeydown="return blockEnter(event);"
                                  binding="#{ordenCirugiaUsuarioBean.mnuAyudantia}"
                                  disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                  value="#{ordenCirugiaUsuarioBean.orden.hoceayudantia}">
                  <f:selectItems value="#{ordenCirugiaUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAyudantia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:outputText/>
              <h:outputText value="Estancia " styleClass="labelTextOblig"/>
              <h:panelGroup id="outputDiasInstancia">
                <h:outputText value="Dias" styleClass="labelTextOblig"
                              rendered="#{ordenCirugiaUsuarioBean.esHospitalaria}"/>
              </h:panelGroup>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="2">
                  <h:selectOneRadio id="mnuEstancia" required="true" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    binding="#{ordenCirugiaUsuarioBean.mnuEstancia}"
                                    disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                    value="#{ordenCirugiaUsuarioBean.orden.hocctipoestanc}"
                                    valueChangeListener="#{ordenCirugiaUsuarioBean.setEstanciaSelect}">
                    <f:selectItems value="#{ordenCirugiaUsuarioBean.lstEstancia}"/>
                    <a4j:support id="supportEstancia" event="onclick" immediate="true"
                                 action="#{ordenCirugiaUsuarioBean.changeEstancia}"
                                 reRender="inputTextDiasInstancia,outputDiasInstancia">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuEstancia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
              </a4j:region>
              <h:panelGroup id="inputTextDiasInstancia">
                <h:inputText id="itDiasEstancia" required="true" immediate="true" maxlength="2" style="width:50px"
                             binding="#{ordenCirugiaUsuarioBean.inputDias}" onkeydown="return blockEnter(event);"
                             value="#{ordenCirugiaUsuarioBean.orden.hocndiasestanc}"
                             disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                             rendered="#{ordenCirugiaUsuarioBean.esHospitalaria}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiasEstancia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText value="Reserva de Sangre" styleClass="labelTextOblig"/>
              <h:panelGroup id="panelOutputUnidades">
                <h:outputText value="Unidades" styleClass="labelTextOblig"
                              rendered="#{ordenCirugiaUsuarioBean.necesitaReserva}"/>
              </h:panelGroup>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="2">
                  <h:selectOneRadio id="mnuReserva" immediate="true" required="true"
                                    onkeydown="return blockEnter(event);"
                                    binding="#{ordenCirugiaUsuarioBean.mnuReserva}"
                                    disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                    value="#{ordenCirugiaUsuarioBean.orden.hoceresesangre}"
                                    valueChangeListener="#{ordenCirugiaUsuarioBean.setReservaSelect}">
                    <f:selectItems value="#{ordenCirugiaUsuarioBean.lstOpciones}"/>
                    <a4j:support id="supportReserva" event="onclick" immediate="true"
                                 action="#{ordenCirugiaUsuarioBean.changeReserva}"
                                 reRender="panelOutputUnidades,panelInputUnidades">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuReserva" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
              </a4j:region>
              <h:panelGroup id="panelInputUnidades">
                <h:inputText id="itUnidadSangre" maxlength="2" style="width:50px" immediate="true"
                             binding="#{ordenCirugiaUsuarioBean.inputUnidades}" 
                             onkeydown="return blockEnter(event);"
                             required="#{ordenCirugiaUsuarioBean.necesitaReserva}"
                             value="#{ordenCirugiaUsuarioBean.orden.hocnunidadsang}"
                             disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                             rendered="#{ordenCirugiaUsuarioBean.necesitaReserva}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itUnidadSangre" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText value="Tiene Patologia" styleClass="labelTextOblig"/>
              <h:panelGroup id="panelTextPatologia">
                <h:outputText value="Patologia " styleClass="labelTextOblig"
                              rendered="#{ordenCirugiaUsuarioBean.mostrarpatologia}"/>
              </h:panelGroup>
              <h:panelGroup id="outputBiopsa">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                              rendered="#{ordenCirugiaUsuarioBean.otraPatologia && ordenCirugiaUsuarioBean.mostrarpatologia}"/>
                <h:outputText value="Descripci�n Biopsa " styleClass="labelTextOblig"
                              rendered="#{ordenCirugiaUsuarioBean.biopsaCongelacion && ordenCirugiaUsuarioBean.mostrarpatologia}"/>
              </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="mnuTienePatologia" immediate="true"
                                    value="#{ordenCirugiaUsuarioBean.tienePatologia}"
                                    onkeydown="return blockEnter(event);"
                                    binding="#{ordenCirugiaUsuarioBean.mnuTienePatologia}"
                                    disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                    valueChangeListener="#{ordenCirugiaUsuarioBean.setTienePatologia}">
                    <f:selectItems value="#{ordenCirugiaUsuarioBean.lstOpciones}"/>
                    <a4j:support id="supportTienePatologia" event="onclick" immediate="true"
                                 action="#{ordenCirugiaUsuarioBean.changeTienePatologia}"
                                 reRender="panelTextPatologia,panelMnuPatologia,outputBiopsa,mnuBiopsa">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{ordenCirugiaUsuarioBean.mostrarpatologia}">
                    <t:message for="mnuTienePatologia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelMnuPatologia">
                  <h:selectOneMenu id="mnuPatologia" immediate="true" required="true"
                                   onkeydown="return blockEnter(event);"
                                   rendered="#{ordenCirugiaUsuarioBean.mostrarpatologia}"
                                   binding="#{ordenCirugiaUsuarioBean.mnuPatologia}"
                                   disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                   value="#{ordenCirugiaUsuarioBean.orden.hocctipopatolo}"
                                   valueChangeListener="#{ordenCirugiaUsuarioBean.setPatologiaSelect}">
                    <f:selectItems value="#{ordenCirugiaUsuarioBean.lstPatologia}"/>
                    <a4j:support id="supportPatologia" event="onchange" immediate="true"
                                 action="#{ordenCirugiaUsuarioBean.changePatologia}" reRender="outputBiopsa,mnuBiopsa">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{ordenCirugiaUsuarioBean.mostrarpatologia}">
                    <t:message for="mnuPatologia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="mnuBiopsa">
                <h:panelGroup>
                  <h:inputText id="itOtraPato" immediate="true" maxlength="600" style="width:200px"
                               onkeydown="return blockEnter(event);" binding="#{ordenCirugiaUsuarioBean.inputCualOtro}"
                               value="#{ordenCirugiaUsuarioBean.orden.hoccotrapatolo}"
                               rendered="#{ordenCirugiaUsuarioBean.otraPatologia && ordenCirugiaUsuarioBean.mostrarpatologia}"
                               required="#{ordenCirugiaUsuarioBean.otraPatologia}"
                               disabled="#{ordenCirugiaUsuarioBean.modoconsulta}">
                             <f:validateLength maximum="600"/>  
                     </h:inputText>          
                  <a4j:outputPanel ajaxRendered="true"
                                   rendered="#{ordenCirugiaUsuarioBean.otraPatologia && ordenCirugiaUsuarioBean.mostrarpatologia}">
                    <t:message for="itOtraPato" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputTextarea id="itBiopsaConge" immediate="true"
                                   binding="#{ordenCirugiaUsuarioBean.inputCongelacion}"
                                   onkeydown="return blockEnter(event);"
                                   value="#{ordenCirugiaUsuarioBean.orden.hoccbiopsacong}"
                                   rendered="#{ordenCirugiaUsuarioBean.biopsaCongelacion && ordenCirugiaUsuarioBean.mostrarpatologia}"
                                   required="#{ordenCirugiaUsuarioBean.biopsaCongelacion}"
                                   disabled="#{ordenCirugiaUsuarioBean.modoconsulta}" style="width:350px">
                                   <f:validateLength maximum="600"/>
                                   </h:inputTextarea>
                  <a4j:outputPanel ajaxRendered="true"
                                   rendered="#{ordenCirugiaUsuarioBean.biopsaCongelacion && ordenCirugiaUsuarioBean.mostrarpatologia}">
                    <t:message for="itBiopsaConge" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:outputText value="Programar Anestesiologo(a) " styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:outputText/>
              <h:panelGrid columns="2">
                <h:selectOneRadio id="mnuProgramar" required="true"
                                  binding="#{ordenCirugiaUsuarioBean.mnuAnestesiologo}"
                                  onkeydown="return blockEnter(event);"
                                  disabled="#{ordenCirugiaUsuarioBean.modoconsulta}"
                                  value="#{ordenCirugiaUsuarioBean.orden.hoccprogramar}">
                  <f:selectItems value="#{ordenCirugiaUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuProgramar" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:outputText/>
              <h:outputText/>
            </h:panelGrid>
          </s:fieldset>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesOrden"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <a4j:commandButton value="Generar Orden Cirugia" styleClass="btn btn btn-success"
                                reRender="panelGridOrdenCirugia"
                               action="#{ordenCirugiaUsuarioBean.generarOrdenCirugia}"/>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid></h:panelGrid>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionOrdenCirugiaMsg" ajaxRendered="true">
              <t:messages id="msgOrdenCirugiaMsg" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarCirugia" rendered="#{ordenCirugiaUsuarioBean.generoOrden}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelTabBuscadorCirugias" label="Buscar Cirugias"
                rendered="#{ordenCirugiaUsuarioBean.mostrarCirugias}">
      <a4j:region id="regionCirugias" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionCirugias">
          <f:facet name="start">
            <t:div id="chargingCirugias" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <s:fieldset legend="Cirugias" id="fieldSetCirugias" styleClass="fieldset">
          <jsp:include page="/pages/clinico/registro/buscadorCirugia.jsp" flush="true"/>
          <h:panelGrid id="panelGridCirugia0Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupCirugiaBotones1">
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                 action="#{ordenCirugiaUsuarioBean.aceptarCirugia}"
                                 reRender="panelGridOrdendeCirugiaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>