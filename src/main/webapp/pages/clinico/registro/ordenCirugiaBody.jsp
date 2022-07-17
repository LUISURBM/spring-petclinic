<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formOrdenCirugia">
  <a4j:region id="regionOrdenCirugia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionOrdenCirugia">
      <f:facet name="start">
        <t:div id="chargingOrdenCirugia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridOrdendeCirugiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneOrdenDeCirugia"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         selectedIndex="#{ordenCirugiaBean.selectedIndex}"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabOrdenCirugia" label="Cirug�as y procedimientos"
                    rendered="#{!ordenCirugiaBean.mostrarCirugias}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridOrdenCirugia"
                       styleClass="tabContainer">
            <s:fieldset legend="Cirujano" id="fieldCirugias"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelCirugias"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Intervenci�n(es) Propuesta(s)"
                              styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:panelGrid columns="2" border="0" cellpadding="0"
                             cellspacing="0" width="100%"
                             id="panelBotonConsulta"
                             columnClasses="columnaBotonesCentrados">
                  <a4j:commandLink value="" immediate="true"
                                   title="Seleccionar Cirugias"
                                   rendered="#{!ordenCirugiaBean.modoconsulta}"
                                   action="#{ordenCirugiaBean.consultarCirugias}"
                                   styleClass="boton_fieldset"
                                   reRender="panelGridOrdendeCirugiaTab"
                                   id="idButt">
                    <t:graphicImage id="imagelupa" border="0"  alt="" 
                                    url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="imagelupa" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           rendered="#{not empty ordenCirugiaBean.lstExamenesCirugias}"
                           cellspacing="0" width="100%"
                           id="tableContentTabsBucar" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"
                               binding="#{ordenCirugiaBean.dtServicios}"
                               value="#{ordenCirugiaBean.lstExamenesCirugias}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtCirugia">
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
                    <h:column rendered="#{!ordenCirugiaBean.modoconsulta}">
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <h:commandLink id="aceptarCirugias" immediate="true"
                                     action="#{ordenCirugiaBean.eliminarCirugia}">
                        <t:graphicImage alt=""  border="0"
                                        url="/comun/imagenes/adicionar.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtCirugia" fastStep="10"
                                    pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                        border="0"/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
              <h:panelGrid columns="3" border="0" cellpadding="0"
                           rendered="#{ordenCirugiaBean.esValoracionPreanestesica}"
                           cellspacing="0" width="100%"
                           id="panelInformacionPreanestesia"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Anestesia General"/>
                <h:outputText value="Anestesia Regional"/>
                <h:outputText value="Anestesia Local Controlada"/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuAnestesiaGeneral"
                                    disabled="#{ordenCirugiaBean.modoconsulta}"
                                    value="#{ordenCirugiaBean.orden.hoccanestgener}">
                    <f:selectItems value="#{ordenCirugiaBean.lstPreferenciaAnestesia}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuAnestesiaRegional"
                                        disabled="#{ordenCirugiaBean.modoconsulta}"
                                    value="#{ordenCirugiaBean.orden.hoccanestregio}">
                    <f:selectItems value="#{ordenCirugiaBean.lstPreferenciaAnestesia}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuAnestesiaLocal"
                                    disabled="#{ordenCirugiaBean.modoconsulta}"
                                    value="#{ordenCirugiaBean.orden.hoccanestlocal}">
                    <f:selectItems value="#{ordenCirugiaBean.lstPreferenciaAnestesia}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
              </h:panelGrid>
              
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelObservacionesCirugias"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Observaciones" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:panelGroup>
                  <h:inputTextarea id="textObservaciones" required="true"
                                   immediate="true"
                                   disabled="#{ordenCirugiaBean.modoconsulta}"
                                   value="#{ordenCirugiaBean.orden.hoccobservacio}"
                                   style="width:500px"/>
               
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textObservaciones" styleClass="errorMessage"/>
                </a4j:outputPanel>
                 </h:panelGroup>
                <h:outputText/>
                <h:panelGroup>
                <h:outputText value="Programar Cirugia" rendered="#{ordenCirugiaBean.esValoracionPreanestesica}"/>
                </h:panelGroup>
                <h:panelGroup id = "panelOutputRazones">
                <h:outputText value="Razones por las cuales no se programa la cirug�a" 
                rendered="#{ordenCirugiaBean.mostrarRazones}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="mnuProgramarCirugia" immediate="true"
                                    rendered="#{ordenCirugiaBean.esValoracionPreanestesica}"
                                    disabled="#{ordenCirugiaBean.modoconsulta}"
                                    value="#{ordenCirugiaBean.orden.hoccprogrcirug}"
                                    valueChangeListener="#{ordenCirugiaBean.setHoccprogrcirug}">
                    <f:selectItems value="#{ordenCirugiaBean.lstOpciones}"/>
                     <a4j:support id="supportmnuProgramarCirugia"
                                   event="onclick" immediate="true"
                                   action="#{ordenCirugiaBean.changeProgramarCirugia}"
                                   reRender="panelOutputRazones,panelInputRazones,panelMenuAceptaProce,panelOutputAceptaProce,outputLugarProcedimiento,inputLugarProcedimiento,tableFechasCirugia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                  </h:selectOneRadio>
                     <a4j:outputPanel ajaxRendered="true"   rendered="#{ordenCirugiaBean.esValoracionPreanestesica}">
                  <t:message for="mnuProgramarCirugia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                </h:panelGroup>
                </a4j:region>
                <h:panelGroup id = "panelInputRazones">
                <h:inputTextarea id = "itRazonCirugia" required="true" style="width:250px"
                disabled="#{ordenCirugiaBean.modoconsulta}"
                rendered="#{ordenCirugiaBean.mostrarRazones}"
                value = "#{ordenCirugiaBean.orden.hoccrazoncirug}"/>
                   <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itRazonCirugia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                </h:panelGroup>
                </h:panelGrid>
                
               
                  <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelAceptaCirugias"
                           rowClasses="labelText,labelTextInfo">
                
                <h:panelGroup id = "panelOutputAceptaProce">
                  <h:outputText value="La Paciente acepta y entiende el procedimiento" styleClass="labelTextOblig"
                  rendered = "#{!ordenCirugiaBean.esValoracionPreanestesica || ordenCirugiaBean.mostrarAcepta}"/>
                </h:panelGroup>
                <h:panelGroup id="outputLugarProcedimiento">
                  <h:outputText value="Lugar de realizaci�n del procedimiento" styleClass="labelTextOblig"
                                rendered="#{ordenCirugiaBean.mostrarLugar}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGrid columns="2" id ="panelMenuAceptaProce">
                    <h:selectOneRadio id="mnuAceptaProcedimiento"
                                     rendered = "#{!ordenCirugiaBean.esValoracionPreanestesica || ordenCirugiaBean.mostrarAcepta}"
                                      immediate="true"
                                      disabled="#{ordenCirugiaBean.modoconsulta}"
                                      required="true"
                                      binding="#{ordenCirugiaBean.mnuAcepta}"
                                      value="#{ordenCirugiaBean.orden.hoccpaciacepta}"
                                      valueChangeListener="#{ordenCirugiaBean.setHoccpaciacepta}">
                      <f:selectItems value="#{ordenCirugiaBean.lstOpciones}"/>
                      <a4j:support id="supportmnuAceptaProcedimiento"
                                   event="onclick" immediate="true"
                                   action="#{ordenCirugiaBean.changeAcepta}"
                                   reRender="outputLugarProcedimiento,inputLugarProcedimiento,tableFechasCirugia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuAceptaProcedimiento"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </a4j:region>
                <h:panelGroup id="inputLugarProcedimiento">
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:selectOneMenu id="mnuLugarProcedimiento"
                                       immediate="true"
                                       disabled="#{ordenCirugiaBean.modoconsulta}"
                                       binding="#{ordenCirugiaBean.mnuLugar}"
                                       rendered="#{ordenCirugiaBean.mostrarLugar}"
                                       required="true"
                                       value="#{ordenCirugiaBean.orden.hocclugarinter}"
                                       valueChangeListener="#{ordenCirugiaBean.setHocclugarinter}">
                        <f:selectItems value="#{ordenCirugiaBean.lstLugar}"/>
                        <a4j:support id="supportmnuLugarProcedimiento"
                                     event="onchange" immediate="true"
                                     action="#{ordenCirugiaBean.changeLugar}"
                                     reRender="tableFechasCirugia">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuLugarProcedimiento"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGrid>
                  </a4j:region>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="tableFechasCirugia">
              <s:fieldset legend="Fechas Cirugia" id="fieldFechaCirugia"
                          styleClass="fieldset"
                          rendered="#{ordenCirugiaBean.mostrarProgramacion}">
                <h:panelGrid columns="3" border="0" cellpadding="0"
                             cellspacing="0" width="100%" id="panelDatosCirugia"
                             rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Tiempo Qx  "
                                styleClass="labelTextOblig"/>
                  <h:outputText/>
                   <h:outputText/>
                  <h:panelGrid columns="3">
                    <h:selectOneMenu id="mnuTiempo" immediate="true"
                                     binding="#{ordenCirugiaBean.mnuTiempo}"
                                     value="#{ordenCirugiaBean.tiempoSelect}"
                                     required="true"
                                     disabled="#{ordenCirugiaBean.modoconsulta}">
                      <f:selectItems value="#{ordenCirugiaBean.lstDuracion}"/>
                    </h:selectOneMenu>
                    <h:outputText value=" Minutos"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTiempo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  <h:outputText/>
                  <h:outputText/>
                  <h:outputText value="Fecha probable de cirugia 1"
                                styleClass="labelTextOblig"/>
                  <h:outputText value="Hora" styleClass="labelTextOblig"/>
                  <h:outputText/>
                  <h:panelGrid columns="2">
                    <t:inputCalendar id="fechaCirugia" immediate="true"
                                     monthYearRowClass="yearMonthHeader"
                                     title="Formato: dd/mm/yyyy"
                                     binding="#{ordenCirugiaBean.mnuFecha1}"
                                     disabled="#{ordenCirugiaBean.modoconsulta}"
                                     weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true"
                                     value="#{ordenCirugiaBean.orden.hocdfecprocir1}"
                                     popupTodayString="Hoy"
                                     popupWeekString="Semana"
                                     popupButtonString="Fecha" readonly="false"
                                     maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top"
                                     required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaCirugia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  <h:panelGroup>
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuHoraCirugia1" required="true"
                                       immediate="true"
                                       binding="#{ordenCirugiaBean.mnuHora1}"
                                       disabled="#{ordenCirugiaBean.modoconsulta}"
                                       value="#{ordenCirugiaBean.horaSelect}">
                        <f:selectItems value="#{ordenCirugiaBean.listHora}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuHoraCirugia1"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                    <h:outputText value=" : "/>
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuMinutosCirugia1" required="true"
                                       immediate="true"
                                       binding="#{ordenCirugiaBean.mnuMinuto1}"
                                       disabled="#{ordenCirugiaBean.modoconsulta}"
                                       value="#{ordenCirugiaBean.minutoSelect}">
                        <f:selectItems value="#{ordenCirugiaBean.lstMinutos}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuMinutosCirugia1"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGroup>
                  <h:outputText/>
                  <h:outputText value="Fecha probable de cirugia 2 "/>
                  <h:outputText value="Hora"/>
                  <h:outputText/>
                  <h:panelGroup>
                    <t:inputCalendar id="fechaCirugia2"
                                     monthYearRowClass="yearMonthHeader"
                                     binding="#{ordenCirugiaBean.mnuFecha2}"
                                     disabled="#{ordenCirugiaBean.modoconsulta}"
                                     weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell"
                                     popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true"
                                     value="#{ordenCirugiaBean.orden.hocdfecprocir2}"
                                     popupTodayString="Hoy"
                                     popupWeekString="Semana"
                                     popupButtonString="Fecha" readonly="false"
                                     maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true"
                                     align="top"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaCirugia2" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuHoraCirugia2"
                                       binding="#{ordenCirugiaBean.mnuHora2}"
                                       disabled="#{ordenCirugiaBean.modoconsulta}"
                                       value="#{ordenCirugiaBean.horaSelect2}">
                        <f:selectItems value="#{ordenCirugiaBean.listHora}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuHoraCirugia2"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                    <h:outputText value=" : "/>
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuMinutosCirugia2"
                                       binding="#{ordenCirugiaBean.mnuMinuto2}"
                                       disabled="#{ordenCirugiaBean.modoconsulta}"
                                       value="#{ordenCirugiaBean.minutoSelect2}">
                        <f:selectItems value="#{ordenCirugiaBean.lstMinutos}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuMinutosCirugia2"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGroup>
                  <h:outputText/>
                  <h:outputText value="Anestesia Solicitada "
                                styleClass="labelTextOblig"/>
                  <h:outputText value="Ayudantia" styleClass="labelTextOblig"/>
                  <h:outputText/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuAnestesia" required="true"
                                     immediate="true"
                                     binding="#{ordenCirugiaBean.mnuAnestesia}"
                                     disabled="#{ordenCirugiaBean.modoconsulta}"
                                     value="#{ordenCirugiaBean.orden.hocctipoaneste}">
                      <f:selectItems value="#{ordenCirugiaBean.lstTipoAnestesia}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuAnestesia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGrid columns="2">
                    <h:selectOneRadio id="mnuAyudantia" required="true"
                                      immediate="true"
                                      binding="#{ordenCirugiaBean.mnuAyudantia}"
                                      disabled="#{ordenCirugiaBean.modoconsulta}"
                                      value="#{ordenCirugiaBean.orden.hoceayudantia}">
                      <f:selectItems value="#{ordenCirugiaBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuAyudantia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  <h:outputText/>
                  <h:outputText value="Estancia " styleClass="labelTextOblig"/>
                  <h:panelGroup id="outputDiasInstancia">
                    <h:outputText value="Dias" styleClass="labelTextOblig"
                                  rendered="#{ordenCirugiaBean.esHospitalaria}"/>
                  </h:panelGroup>
                  <h:outputText/>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:selectOneRadio id="mnuEstancia" required="true"
                                        immediate="true"
                                        binding="#{ordenCirugiaBean.mnuEstancia}"
                                        disabled="#{ordenCirugiaBean.modoconsulta}"
                                        value="#{ordenCirugiaBean.orden.hocctipoestanc}"
                                        valueChangeListener="#{ordenCirugiaBean.setEstanciaSelect}">
                        <f:selectItems value="#{ordenCirugiaBean.lstEstancia}"/>
                        <a4j:support id="supportEstancia" event="onclick"
                                     immediate="true"
                                     action="#{ordenCirugiaBean.changeEstancia}"
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
                    <h:inputText id="itDiasEstancia" required="true"
                                 immediate="true" maxlength="2"
                                 style="width:50px"
                                 binding="#{ordenCirugiaBean.inputDias}"
                                 onkeydown="return blockEnter(event);"
                                 value="#{ordenCirugiaBean.orden.hocndiasestanc}"
                                 disabled="#{ordenCirugiaBean.modoconsulta}"
                                 rendered="#{ordenCirugiaBean.esHospitalaria}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDiasEstancia"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText/>
                  <h:outputText value="Reserva de Sangre"
                                styleClass="labelTextOblig"/>
                  <h:panelGroup id="panelOutputUnidades">
                    <h:outputText value="Unidades" styleClass="labelTextOblig"
                                  rendered="#{ordenCirugiaBean.necesitaReserva}"/>
                  </h:panelGroup>
                  <h:outputText/>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:selectOneRadio id="mnuReserva" immediate="true"
                                        required="true"
                                        binding="#{ordenCirugiaBean.mnuReserva}"
                                        disabled="#{ordenCirugiaBean.modoconsulta}"
                                        value="#{ordenCirugiaBean.orden.hoceresesangre}"
                                        valueChangeListener="#{ordenCirugiaBean.setReservaSelect}">
                        <f:selectItems value="#{ordenCirugiaBean.lstOpciones}"/>
                        <a4j:support id="supportReserva" event="onclick"
                                     immediate="true"
                                     action="#{ordenCirugiaBean.changeReserva}"
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
                    <h:inputText id="itUnidadSangre" maxlength="2"
                                 style="width:50px" immediate="true"
                                 binding="#{ordenCirugiaBean.inputUnidades}"
                                 onkeydown="return blockEnter(event);"
                                 required="#{ordenCirugiaBean.necesitaReserva}"
                                 value="#{ordenCirugiaBean.orden.hocnunidadsang}"
                                 disabled="#{ordenCirugiaBean.modoconsulta}"
                                 rendered="#{ordenCirugiaBean.necesitaReserva}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itUnidadSangre"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText/>
                 <h:outputText value = "Tiene Patologia" styleClass="labelTextOblig"/>
                 <h:panelGroup id = "panelTextPatologia">
                  <h:outputText value="Patologia " styleClass="labelTextOblig"
                    rendered = "#{ordenCirugiaBean.mostrarpatologia}"/>
                  </h:panelGroup>
                 <h:panelGroup id="outputBiopsa">
                    <h:outputText value="Cual" styleClass="labelTextOblig"
                                  rendered="#{ordenCirugiaBean.otraPatologia && ordenCirugiaBean.mostrarpatologia}"/>
                    <h:outputText value="Descripci�n Biopsa "
                                  styleClass="labelTextOblig"
                                  rendered="#{ordenCirugiaBean.biopsaCongelacion && ordenCirugiaBean.mostrarpatologia}"/>
                  </h:panelGroup> 
            <a4j:region renderRegionOnly="false">
               <h:panelGroup>
                <h:selectOneRadio id = "mnuTienePatologia" immediate="true"
                    value = "#{ordenCirugiaBean.tienePatologia}"
                    binding="#{ordenCirugiaBean.mnuTienePatologia}"
                    disabled="#{ordenCirugiaBean.modoconsulta}"
                    valueChangeListener="#{ordenCirugiaBean.setTienePatologia}">
                   <f:selectItems value = "#{ordenCirugiaBean.lstOpciones}"/>
                    <a4j:support id="supportTienePatologia" event="onclick"
                                     immediate="true"
                                      action="#{ordenCirugiaBean.changeTienePatologia}"
                                     reRender="panelTextPatologia,panelMnuPatologia,outputBiopsa,mnuBiopsa">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                </h:selectOneRadio>
                 <a4j:outputPanel ajaxRendered="true" rendered = "#{ordenCirugiaBean.mostrarpatologia}">
                        <t:message for="mnuTienePatologia"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
               </h:panelGroup>
            </a4j:region>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGroup id = "panelMnuPatologia">
                      <h:selectOneMenu id="mnuPatologia" immediate="true"
                                       required="true"
                                       rendered = "#{ordenCirugiaBean.mostrarpatologia}"
                                       binding="#{ordenCirugiaBean.mnuPatologia}"
                                       disabled="#{ordenCirugiaBean.modoconsulta}"
                                       value="#{ordenCirugiaBean.orden.hocctipopatolo}"
                                       valueChangeListener="#{ordenCirugiaBean.setPatologiaSelect}">
                        <f:selectItems value="#{ordenCirugiaBean.lstPatologia}"/>
                        <a4j:support id="supportPatologia" event="onchange"
                                     immediate="true"
                                     action="#{ordenCirugiaBean.changePatologia}"
                                     reRender="outputBiopsa,mnuBiopsa">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true" rendered = "#{ordenCirugiaBean.mostrarpatologia}">
                        <t:message for="mnuPatologia"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </a4j:region>
           <h:panelGroup id="mnuBiopsa">
                    <h:panelGroup>
                      <h:inputText id="itOtraPato" immediate="true"
                                   maxlength="600" style="width:200px"
                                   onkeydown="return blockEnter(event);"
                                   binding="#{ordenCirugiaBean.inputCualOtro}"
                                   value="#{ordenCirugiaBean.orden.hoccotrapatolo}"
                                   rendered="#{ordenCirugiaBean.otraPatologia && ordenCirugiaBean.mostrarpatologia}"
                                   required="#{ordenCirugiaBean.otraPatologia}"
                                   disabled="#{ordenCirugiaBean.modoconsulta}"/>
                      <a4j:outputPanel ajaxRendered="true"   rendered="#{ordenCirugiaBean.otraPatologia && ordenCirugiaBean.mostrarpatologia}">
                        <t:message for="itOtraPato" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                    <h:panelGroup>
                      <h:inputTextarea id="itBiopsaConge" immediate="true"
                                       binding="#{ordenCirugiaBean.inputCongelacion}"
                                       value="#{ordenCirugiaBean.orden.hoccbiopsacong}"
                                       rendered="#{ordenCirugiaBean.biopsaCongelacion && ordenCirugiaBean.mostrarpatologia}"
                                       required="#{ordenCirugiaBean.biopsaCongelacion}"
                                       disabled="#{ordenCirugiaBean.modoconsulta}"
                                       style="width:350px"/>
                      <a4j:outputPanel ajaxRendered="true"    rendered="#{ordenCirugiaBean.biopsaCongelacion && ordenCirugiaBean.mostrarpatologia}">
                        <t:message for="itBiopsaConge"
                                   styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGroup>
                  
                  
                <h:outputText value="Programar Anestesiologo(a) "
                                styleClass="labelTextOblig"/>
                                  <h:outputText/>
                                    <h:outputText/>
                                    
                                    
                                     <h:panelGrid columns="2">
                    <h:selectOneRadio id="mnuProgramar" required="true"
                                      binding="#{ordenCirugiaBean.mnuAnestesiologo}"
                                      disabled="#{ordenCirugiaBean.modoconsulta}"
                                      value="#{ordenCirugiaBean.orden.hoccprogramar}">
                      <f:selectItems value="#{ordenCirugiaBean.lstOpciones}"/>
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
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonesOrden"
                         columnClasses="panelGridBotones">
                         
                         
              <h:panelGroup>
                <a4j:commandButton value="Generar Orden Cirugia"
                                   styleClass="boton_fieldset"
                                   disabled="#{ordenCirugiaBean.modoconsulta}"
                                   reRender="panelGridOrdenCirugia"
                                   action="#{ordenCirugiaBean.generarOrdenCirugia}"/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid></h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionOrdenCirugiaMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgOrdenCirugiaMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <f:subview id="generarCirugia"
                       rendered="#{ordenCirugiaBean.generoOrden}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
              </f:verbatim>
            </f:subview>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelTabBuscadorCirugias" label="Bucar Cirugias"
                    rendered="#{ordenCirugiaBean.mostrarCirugias}">
          <a4j:region id="regionCirugias" renderRegionOnly="false">
            <a4j:status for="regionCirugias">
              <f:facet name="start">
                <t:div id="chargingCirugias" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0"
                               border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <s:fieldset legend="Cirugias" id="fieldSetCirugias"
                        styleClass="fieldset">
              <jsp:include page="/pages/clinico/registro/buscadorCirugia.jsp"
                           flush="true"/>
              <h:panelGrid id="panelGridCirugia0Botones" width="100%"
                           columnClasses="columnaBotonesCentrados" dir="RTL">
                <t:htmlTag value="br"/>
                <h:panelGroup id="panelGroupCirugiaBotones1">
                  <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     action="#{ordenCirugiaBean.aceptarCirugia}"
                                     reRender="panelGridOrdendeCirugiaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>