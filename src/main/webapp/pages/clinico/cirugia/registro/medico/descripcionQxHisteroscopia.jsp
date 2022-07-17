<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>

<a4j:region id="regionDescripcionQuirurgica" renderRegionOnly="false">
  <a4j:status id="statusButton" for="regionDescripcionQuirurgica">
    <f:facet name="start">
      <t:div id="chargingDescripcionQuirurgica" styleClass="loading">
        <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
          <h:outputText value="Procesando..."/>
          <h:outputText value="Por favor espere."/>
        </h:panelGrid>
      </t:div>
    </f:facet>
    <f:facet name="stop"/>
  </a4j:status>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
               id="panelGridDescripcionQuirurgicaTab" styleClass="tabContainer">
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneDescripcionQuirurgica"
                       selectedIndex="#{descripcionQuirurgicaBean.selectedIndex}" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabDescripcionQuirurgica" label="#{descripcionQuirurgicaBean.labelEncabezado}"
                  disabled="#{descripcionQuirurgicaBean.mostrarCie10 || descripcionQuirurgicaBean.renderPlantilla}">
        <s:fieldset legend="#{descripcionQuirurgicaBean.labelfielSet} Histeroscopia" 
        id="fieldCirugiasDescripcion" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugiasDescripcion"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="#{descripcionQuirurgicaBean.labelIntervecionesPropuestas}"/>
            <h:outputText/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty descripcionQuirurgicaBean.lstDetalleCirugias}" cellspacing="0" width="100%"
                       id="tableCirugiasDescripcionQx" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           value="#{descripcionQuirurgicaBean.lstDetalleCirugias}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="dtDescripcionQX">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo"/>
                  </f:facet>
                  <h:outputText value="#{item.id.hdccservicio}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"/>
                  </f:facet>
                  <h:outputText value="#{item.hdccdescrservi}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Medico"/>
                  </f:facet>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuProfesionalesDq" value="#{item.hdcnmedicatien}" disabled="true">
                      <f:selectItems value="#{descripcionQuirurgicaBean.lstProfesionalesIntervencion}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuProfesionalesDq" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <h:outputText value="#{table}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
        <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true"
                 displayAtDistanceX="-155" displayAtDistanceY="10">
          <h:commandLink id="imprimirReporteLiquidosDQX" immediate="true" value="Visualizar Liquidos"
                         action="#{descripcionQuirurgicaBean.generarReporteLiquidos}">
            <t:graphicImage title="Reporte Liquidos" alt="" border="0" url="/comun/imagenes/pdfIcon.png"/>
          </h:commandLink>
          <f:facet name="popup">
            <h:panelGroup>
              <h:panelGrid columns="2" style="text-align:left;">
                <h:outputText value="Reporte Liquidos"/>
              </h:panelGrid>
            </h:panelGroup>
          </f:facet>
        </t:popup>
        <s:fieldset legend="#{descripcionQuirurgicaBean.labelfielSet2}"  id="fieldDescripcionQuirugica" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAmbito"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Ambito del Procedimiento" styleClass="labelTextOblig"/>
            <h:outputText value="Finalidad del Procedimiento" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuAmbito" value="#{descripcionQuirurgicaBean.descripcion.hdqnambito}">
                <f:selectItems value="#{descripcionQuirurgicaBean.lstAmbitoProcedimiento}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAmbito" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="mnuFinalidad" immediate="true"
                               value="#{descripcionQuirurgicaBean.detalleDescripcion.hddnfinalidad}" required="true">
                <f:selectItems value="#{descripcionQuirurgicaBean.lstFinalidad}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuFinalidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Forma Realizacion del procedimiento" styleClass="labelTextOblig"/>
            <h:outputText value="Fecha del Procedimiento" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuFormaProcedimiento" immediate="true"
                               value="#{descripcionQuirurgicaBean.descripcion.hdqnformareali}" required="true"
                               styleClass="input-xxlarge">
                <f:selectItems value="#{descripcionQuirurgicaBean.lstFormaProcedimiento}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuFormaProcedimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelCalendarProcedimiento">
              <t:inputCalendar id="fechaProcedimiento" title="Formato: dd/mm/yyyy" styleClass="input-small"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{descripcionQuirurgicaBean.descripcion.hdqdfechaproce}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaProcedimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value = "#{descripcionQuirurgicaBean.labelSala}" styleClass="labelTextOblig"/>
            <h:outputText value = "#{descripcionQuirurgicaBean.labeltiempo}" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:selectOneMenu id="idSalaCirugia" title="Sala de Cirugia" styleClass="input-small"
                               value="#{descripcionQuirurgicaBean.descripcion.hdqnsalacirugi}">
                <f:selectItems value="#{descripcionQuirurgicaBean.lstSalasCirugia}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="idSalaCirugia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGrid columns="5">
              <h:panelGroup>
                <h:selectOneMenu id="mnuTiempoHora" title="Tiempo en Horas" styleClass="input-small" immediate="true"
                                 required="true" value="#{descripcionQuirurgicaBean.detalleDescripcion.hddntiempohora}">
                  <f:selectItems value="#{descripcionQuirurgicaBean.lstHora}"/>
                </h:selectOneMenu>
                <h:outputText value=" :"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTiempoHora" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Hora(s)"/>
              <h:panelGroup>
                <h:selectOneMenu id="mnuTiempoMinuto" title="Tiempo en Minutos" styleClass="input-small"
                                 immediate="true" required="true"
                                 value="#{descripcionQuirurgicaBean.detalleDescripcion.hddntiempominu}">
                  <f:selectItems value="#{descripcionQuirurgicaBean.lstMinutos}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTiempoMinuto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="Minuto(s)"/>
            </h:panelGrid>
            <h:outputText value=""/>
            <h:outputText value="Circulante" styleClass="labelTextOblig"/>
             <h:outputText value=""/>
               <h:selectOneMenu id="idCirculante" immediate="true" required="true"
                               value="#{descripcionQuirurgicaBean.detalleDescripcion.hddncirculante}">
                <f:selectItems value="#{descripcionQuirurgicaBean.lstCirculante}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="idCirculante" styleClass="errorMessage"/>
              </a4j:outputPanel>
            <h:panelGroup id="panelInstrumentador">
              <h:outputText value="Instrumentador" styleClass="labelTextOblig"
                         />
            </h:panelGroup>
            <h:outputText value=""/>
            <h:panelGroup>
              <h:selectOneMenu id="idInstrumentadora" immediate="true" required="true"
                               value="#{descripcionQuirurgicaBean.detalleDescripcion.hddninstrument}">
                <f:selectItems value="#{descripcionQuirurgicaBean.lstInstrumentador}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="idInstrumentadora" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Anestesia" id="fieldProgramacionAnestesiologo" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       rowClasses="labelText,labelTextInfo" id="tableAnestesia">
            <h:outputText value="Tipo de Anestesia" styleClass="labelTextOblig"/>
             <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneMenu id="mnuTipoAnestesia"
                               binding="#{descripcionQuirurgicaBean.mnuTipoAnestesia}"
                               value="#{descripcionQuirurgicaBean.detalleDescripcion.hddctipoaneste}"
                               valueChangeListener="#{descripcionQuirurgicaBean.setHddctipoaneste}" >
                <f:selectItems value="#{descripcionQuirurgicaBean.lstTipoAnestesia}"/>
                 <a4j:support id="supportAnestesia" event="onchange" action="#{descripcionQuirurgicaBean.changeAnestesia}"
                                 reRender="pgAnestesiologo,fieldProgramacionAnestesiologo">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTipoAnestesia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            </a4j:region>
          </h:panelGrid>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup id="pgAnestesiologo">
            <h:panelGrid columns="1" border="0" rendered="#{descripcionQuirurgicaBean.renderAnestesiologo}" cellpadding="0" cellspacing="0" width="100%"
                         rowClasses="labelText,labelTextInfo" id="tableAnestesiologos">
              <h:outputText value="Anestesiologo(s)" rendered="#{descripcionQuirurgicaBean.renderAnestesiologo}"/>
              <h:panelGrid columns="2">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuAnestesiologo" required="true" rendered="#{descripcionQuirurgicaBean.renderAnestesiologo}" value="#{descripcionQuirurgicaBean.anestesiologoSelect}">
                    <f:selectItems value="#{descripcionQuirurgicaBean.lstAnestesiologo}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuAnestesiologo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:commandLink id="agregarAnestesiologo"  action="#{descripcionQuirurgicaBean.agregarAnestesiologo}"
                                 value="Agregar" reRender="tableAnestesiologoSeleccionado">
                  <t:graphicImage border="0" url="/comun/imagenes/fnd_boton_agregar.gif" alt="Agregar"/>
                </a4j:commandLink>
              </h:panelGrid>
            </h:panelGrid>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableAnestesiologoSeleccionado" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           rendered="#{not empty descripcionQuirurgicaBean.lstAnestesiologosSelect}"
                           binding="#{descripcionQuirurgicaBean.dtAnestesiologo}"
                           value="#{descripcionQuirurgicaBean.lstAnestesiologosSelect}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtAnestesiologo">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo"/>
                  </f:facet>
                  <h:outputText value="#{item.id.cpfncodigo}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"/>
                  </f:facet>
                  <h:outputText value="#{item.cpfcnombre}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <a4j:commandLink id="eliminar"
                                   onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                   action="#{descripcionQuirurgicaBean.eliminarAnestesiologo}" immediate="true"
                                   reRender="fieldProgramacionAnestesiologo">
                    <t:graphicImage border="0" alt="" url="/comun/imagenes/quitar.gif"/>
                  </a4j:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll" for="dtAnestesiologo" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage url="/comun/imagenes/primero.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage url="/comun/imagenes/ultimo.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage url="/comun/imagenes/anterior.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage url="/comun/imagenes/siguiente.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage url="/comun/imagenes/adelante.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage url="/comun/imagenes/atras.gif" alt="" border="0"/>
                  </f:facet>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
          </a4j:region>
        </s:fieldset>
        <s:fieldset legend="Ayudantia" id="fieldProgramacionAyudantia" styleClass="fieldset">
        <h:panelGrid  columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelAyundatia" rowClasses="labelText,labelTextInfo">
            <h:outputText value = "Ayudante 1" styleClass="labelTextOblig"/>
            <h:outputText value = ""/>
            <h:panelGroup id = "panelTextNombreResidente1">
            <h:outputText value = "Nombre Residente" rendered="#{descripcionQuirurgicaBean.renderAyudante1}" />
            </h:panelGroup>
            <h:outputText value = ""/>
            <h:outputText value = "Ayudante 2" styleClass="labelTextOblig"/>
            <h:outputText value = ""/>
              <h:panelGroup id = "panelTextNombreResidente2">
            <h:outputText value = "Nombre Residente" rendered="#{descripcionQuirurgicaBean.renderAyudante2}"/>
            </h:panelGroup>
            <h:outputText value = ""/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="mnuAyudantia1" immediate="true" required="true"
                        value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcmediayud1}"
                        valueChangeListener="#{descripcionQuirurgicaBean.setHddcmediayud1}">
                    <f:selectItems value="#{descripcionQuirurgicaBean.lstProfesionales}"/>
                      <a4j:support id="supportMenuAyudantia1" event="onchange" ignoreDupResponses="true" 
                             immediate="true"
                             action="#{descripcionQuirurgicaBean.changeAyudante1}"
                             reRender="panelTextNombreResidente1,panelInputNombreResidente1">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                  </h:selectOneMenu>
                  </a4j:region>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuAyudantia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                <h:panelGroup id = "panelInputNombreResidente1"> 
                <h:inputText id = "itNombreAyudante1" immediate="true"
                        rendered="#{descripcionQuirurgicaBean.renderAyudante1}" required="true"
                        value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcnomresiden1}"/>
                </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreAyudante1" styleClass="errorMessage"/>
                  </a4j:outputPanel>
             
                    <a4j:region renderRegionOnly="false">
                 <h:selectOneMenu id="mnuAyudantia2" immediate="true" required="true"
                      value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcmediayud2}"
                      valueChangeListener="#{descripcionQuirurgicaBean.setHddcmediayud2}">
                     <f:selectItems value="#{descripcionQuirurgicaBean.lstProfesionales}"/>
                     <a4j:support id="supportMenuAyudantia2" event="onchange" ignoreDupResponses="true" 
                             immediate="true"
                             action="#{descripcionQuirurgicaBean.changeAyudante2}"
                             reRender="panelTextNombreResidente2,panelInputNombreResidente2">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                     </h:selectOneMenu>
                     </a4j:region>
                          <a4j:outputPanel ajaxRendered="true">
                           <t:message for="mnuAyudantia2" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                  <h:panelGroup id = "panelInputNombreResidente2"> 
                    <h:inputText id = "itNombreAyudante2" immediate="true"
                     value = "#{descripcionQuirurgicaBean.detalleDescripcion.hddcnomresiden2}"
                    rendered="#{descripcionQuirurgicaBean.renderAyudante2}" 
                    required="true"/>
                    </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreAyudante2" styleClass="errorMessage"/>
                  </a4j:outputPanel>
        </h:panelGrid>
      
      
        </s:fieldset>
        <s:fieldset legend="Histeroscopia" id="fieldHisteroscopia" styleClass="fieldset">
           <jsp:include page="/pages/clinico/comunes/datosHisteroscopia.jsp" flush="true"/>
        </s:fieldset>
        <s:fieldset legend="Hallazgos" id="fieldHallazgos" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelHallazHistero" width="80%%">
            <h:outputText value="Hallazgos:" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="mnuHallazgosHiste" onkeydown="return blockEnter(event);" immediate="true"
                                    value="#{descripcionQuirurgicaBean.hallazgoHis.hhhchallazgo}"
                                    valueChangeListener="#{descripcionQuirurgicaBean.setHhhchallazgo}">
                    <f:selectItems value="#{descripcionQuirurgicaBean.lstOpciones}"/>
                    <a4j:support id="supportmnuHallazgosHiste" event="onclick"
                                 action="#{descripcionQuirurgicaBean.changeHallazgo}" reRender="panelHallazHistero">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHallazgosHiste" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGroup>
            <h:outputText value="Vaginoscop�a:" styleClass="labelTextOblig"
                          rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}"/>
            <h:panelGroup>
              <h:inputTextarea id="textHallazVaginoscopia" value="#{descripcionQuirurgicaBean.hallazgoHis.hhhcvaginosc}"
                               style="width:650px;height:20px" rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}">
                <f:validateLength maximum="91"/>
              </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textHallazVaginoscopia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Canal Endocervical:" styleClass="labelTextOblig"
                          rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}"/>
                            <h:panelGroup>
            <h:inputTextarea id="textHallazCanEndoce" value="#{descripcionQuirurgicaBean.hallazgoHis.hhhccancervi}"
                             rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}" style="width:650px;height:20px">
              <f:validateLength maximum="91"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textHallazCanEndoce" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Aspecto del endometrio:" styleClass="labelTextOblig"
                          rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}"/>
                            <h:panelGroup>
            <h:inputTextarea id="textHallazAspeEndo" value="#{descripcionQuirurgicaBean.hallazgoHis.hhhcaspeendo}"
                             rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}" style="width:650px;height:20px">
              <f:validateLength maximum="91"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textHallazAspeEndo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Ostiums Tub�ricos:" styleClass="labelTextOblig"
                          rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}"/>
                            <h:panelGroup>
            <h:inputTextarea id="textHallazOstiuTuba" value="#{descripcionQuirurgicaBean.hallazgoHis.hhhcostituba}"
                             rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}" style="width:650px;height:20px">
              <f:validateLength maximum="91"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textHallazOstiuTuba" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Masas intracavitarias:" styleClass="labelTextOblig"
                          rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}"/>
                            <h:panelGroup>
            <h:inputTextarea id="textHallazMaIntra" value="#{descripcionQuirurgicaBean.hallazgoHis.hhhcmasaintr}"
                             rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}" style="width:650px;height:20px">
              <f:validateLength maximum="91"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textHallazMaIntra" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
              
            <h:outputText value="Otros:" styleClass="labelTextOblig"
                          rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}"/>
                          <h:panelGroup>
            <h:inputTextarea id="textHallazOtros" value="#{descripcionQuirurgicaBean.hallazgoHis.hhhcotros}"
                             rendered="#{descripcionQuirurgicaBean.mostrarHallazgos}" style="width:650px;height:20px">
              <f:validateLength maximum="91"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textHallazOtros" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="#{descripcionQuirurgicaBean.labelProcedimientoPracticado}" id="fieldCirugiasDescripciones" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty descripcionQuirurgicaBean.lstCirugias}" cellspacing="0" width="100%"
                       id="tableContentTabsBucar" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           binding="#{descripcionQuirurgicaBean.dtServicios}"
                           value="#{descripcionQuirurgicaBean.lstCirugias}" rows="10" styleClass="standard_table"
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
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="aceptarCirugias" immediate="true"
                                 action="#{descripcionQuirurgicaBean.eliminarCirugia}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
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
            <h:outputText value="#{table}" escape="false"/>
          </h:panelGrid>
       
       
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugias"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="#{descripcionQuirurgicaBean.labelIntervecionesPracticadas}" />
            <h:outputText/>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="imagelupa"
                         columnClasses="columnaBotonesCentrados">
            <a4j:region renderRegionOnly="false">
              <a4j:commandLink action="#{descripcionQuirurgicaBean.renderServicio}" 
                            reRender="panelGridDescripcionQuirurgicaTab"
                             rendered="#{descripcionQuirurgicaBean.registrarCirugia}">
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
              </a4j:commandLink>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="imagelupa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            
          </h:panelGrid>
        </s:fieldset>
        <!-- Datos Cirugia -->
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDiagnosticoPosteriorAplicacion" rowClasses="labelText,labelTextInfo">
          <s:fieldset legend="Diagnosticos" styleClass="fieldset">
            <h:outputText value="Diagnostico Principal" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{descripcionQuirurgicaBean.mostrarDiagnosticoPreoperatorio}" immediate="true"
                               reRender="panelGridDescripcionQuirurgicaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
              </a4j:commandLink>
              <h:inputText id="itDiagPrevioCirugia" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                           immediate="true" binding="#{descripcionQuirurgicaBean.itDiagPreoperatorio}"
                           value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcdiagnprinc}"
                           valueChangeListener="#{descripcionQuirurgicaBean.setHddcdiagnprinc}" style="width:50px"
                           maxlength="4">
                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportItDiagPreCirugia" event="onchange" ignoreDupResponses="true" immediate="true"
                             action="#{descripcionQuirurgicaBean.changeDiagnosticoPreoperatorio}"
                             reRender="panelDiagnosticoPosteriorAplicacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <f:converter converterId="util.ConverterMayuscula"/>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPrevioCirugia" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnostico1Cirugia">
                <h:outputText value=" #{descripcionQuirurgicaBean.diagnosticoPreoperatorio}" styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
            <h:outputText/>
            <h:outputText value="Diagnostico Relacionado 1" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{descripcionQuirurgicaBean.mostrarDiagnosticoPosoperatorio}" immediate="true"
                               reRender="panelGridDescripcionQuirurgicaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
              </a4j:commandLink>
              <h:inputText id="itDiagPosteriorCirugia" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                           immediate="true" binding="#{descripcionQuirurgicaBean.itDiagPostoperatorio}"
                           value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcdiagnrelac}"
                           valueChangeListener="#{descripcionQuirurgicaBean.setHddcdiagnrelac}" style="width:50px"
                           maxlength="4">
                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportItDiagPostCirugia" event="onchange" ignoreDupResponses="true" immediate="true"
                             action="#{descripcionQuirurgicaBean.changeDiagnosticoPostoperatorio}"
                             reRender="panelDiagnosticoPosteriorDescripcion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <f:converter converterId="util.ConverterMayuscula"/>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPosteriorCirugia" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                           id="panelDiagnosticoPosteriorDescripcion">
                <h:outputText value=" #{descripcionQuirurgicaBean.diagnosticoPosoperatorio}" styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
            <h:outputText/>
          </s:fieldset>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDescripcionCirugia"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="#{descripcionQuirurgicaBean.labelDescripcion}" styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
            <a4j:commandLink action="#{descripcionQuirurgicaBean.mostrarBuscadorPlantillaDescripcion}" immediate="true"
                             reRender="panelGridDescripcionQuirurgicaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
            </a4j:commandLink>
            <h:inputTextarea id="textDescripcion" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                             binding="#{descripcionQuirurgicaBean.itDescripcion}" required="true" 
                             value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcdescripcio}"
                             valueChangeListener="#{descripcionQuirurgicaBean.setHddcdescripcio}" style="width:500px">
              <f:converter converterId="cadena.stringUpperCaseConverter"/>
              <f:converter converterId="util.ConverterMayuscula"/>
               <f:validateLength maximum="174"/>
            </h:inputTextarea>
          </h:panelGrid>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textDescripcion" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        ---
        <s:fieldset legend="Complicaciones " id="fieldSetDatosComplicacionAplicacion" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelComplicacionesAplicacion" rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:outputText value="Se presentaron complicaciones?" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="mnuComplicaciones" onkeydown="return blockEnter(event);" immediate="true"
                                    value="#{descripcionQuirurgicaBean.detalleDescripcion.hddctienecompl}"
                                    valueChangeListener="#{descripcionQuirurgicaBean.setHddctienecompl}">
                    <f:selectItems value="#{descripcionQuirurgicaBean.lstOpciones}"/>
                    <a4j:support id="supportmnuComplicacionesCirugia" event="onclick"
                                 action="#{descripcionQuirurgicaBean.changeComplicaciones}"
                                 reRender="panelGroupTextDiagnostico,panelInputDiagnosticoComplicacion,panelTextDescripcionComplicacion,panelInputDescripcionComplicacion,msgTieneComplicaciones">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true"
                           displayAtDistanceX="110" displayAtDistanceY="2">
                    <h:outputText id="msgTieneComplicaciones" value="#{descripcionQuirurgicaBean.msgComplicaciones}"
                                  style="color:blue"/>
                    <f:facet name="popup">
                      <h:panelGroup>
                        <h:panelGrid columns="2">
                          <h:graphicImage url="/comun/imagenes/doctorPausaDescripcion.jpg" alt="doctorPausaEnfermeria"
                                          width="500" height="350"/>
                        </h:panelGrid>
                      </h:panelGroup>
                    </f:facet>
                  </t:popup>
                </h:panelGroup>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuComplicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelGroupTextDiagnostico">
              <h:panelGroup rendered="#{descripcionQuirurgicaBean.mostrarComplicaciones}">
                <h:outputText value="Registrar Diagnostico Complicaci�n" styleClass="labelTextOblig"/>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelInputDiagnosticoComplicacion">
              <h:panelGroup rendered="#{descripcionQuirurgicaBean.mostrarComplicaciones}">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
               
                  <a4j:commandLink action="#{descripcionQuirurgicaBean.mostrarDiagnosticoComplicacion}" 
                                    immediate="true"
                                   reRender="panelGridDescripcionQuirurgicaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                  </a4j:commandLink>
               
                  <a4j:region renderRegionOnly="false">
                    <h:inputText id="itDiagComplicacion" styleClass="textmayuscula"
                                 onkeydown="return blockEnter(event);"
                                 binding="#{descripcionQuirurgicaBean.itDiagComplicacion}"
                                 value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcdiagncompl}"
                                 valueChangeListener="#{descripcionQuirurgicaBean.setHddcdiagncompl}" style="width:50px"
                                 maxlength="4">
                      <f:converter converterId="cadena.stringUpperCaseConverter"/>
                      <a4j:support id="supportitDiagComplicacionCirugia" event="onchange" ignoreDupResponses="true"
                                   action="#{descripcionQuirurgicaBean.changeDiagnosticoComplicacion}"
                                   reRender="panelDiagnosticoComplicacion">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <f:converter converterId="util.ConverterMayuscula"/>
                    </h:inputText>
                  </a4j:region>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDiagComplicacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:panelGroup id="panelDiagnosticoComplicacion">
                    <h:outputText value=" #{descripcionQuirurgicaBean.diagnosticoComplicacion}" styleClass="buscador"/>
                  </h:panelGroup>
                </h:panelGrid>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelTextDescripcionComplicacion">
              <h:outputText value="Descripci�n y manejo Complicaci�n"
                            rendered="#{descripcionQuirurgicaBean.mostrarComplicaciones}" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputDescripcionComplicacion">
              <h:inputTextarea id="inputTextareaComplicaciones" onkeydown="return blockEnter(event);"
                               value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcdescrcompl}"
                               style="width:500px;height:70px"
                               rendered="#{descripcionQuirurgicaBean.mostrarComplicaciones}">
                        <f:validateLength maximum="287"/>
               </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputTextareaComplicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        
        <s:fieldset legend="#{descripcionQuirurgicaBean.labelfielSet3}" id="fieldSetDatosCirugiaAplicacion"
                    styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="80%%"
                       rowClasses="labelText,labelTextInfo" id="tablePiezasHallazgos">
            <h:panelGroup id="panelHalla">
              <h:outputText value="#{descripcionQuirurgicaBean.labelHallazgos}" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                  <a4j:commandLink action="#{descripcionQuirurgicaBean.mostrarBuscadorPlantillaHallazgos}"
                                   immediate="true" reRender="panelGridDescripcionQuirurgicaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                  </a4j:commandLink>
                  <h:inputTextarea id="idHallazgosDescrip" styleClass="textmayuscula"
                                   onkeydown="return blockEnter(event);"
                                   binding="#{descripcionQuirurgicaBean.itHallazgos}" required="true"
                                   value="#{descripcionQuirurgicaBean.detalleDescripcion.hddchallazgos}"
                                   valueChangeListener="#{descripcionQuirurgicaBean.setHddchallazgos}"
                                   style="width:500px">
                    <f:converter converterId="cadena.stringUpperCaseConverter"/>
                    <f:converter converterId="util.ConverterMayuscula"/>
                  </h:inputTextarea>
                </h:panelGrid>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="idHallazgosDescrip" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            </h:panelGrid>
               <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="80%%"
                       rowClasses="labelText,labelTextInfo" id="tablePiezaspatol">
        
            <h:panelGroup>
            <h:outputText value="Remite anatomia patologica" styleClass="labelTextOblig"/>
             <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuPiezas" immediate="true"
                                  value="#{descripcionQuirurgicaBean.detalleDescripcion.hddctienepiepa}"
                                  valueChangeListener="#{descripcionQuirurgicaBean.setHddctienepiepa}">
                  <f:selectItems value="#{descripcionQuirurgicaBean.lstOpciones}"/>
                  <a4j:support id="supportPiezasPatologia" event="onclick"
                               action="#{descripcionQuirurgicaBean.changePiezasPatologia}"
                               reRender="panelTextPiezas,panelPiezasPatologia,panelImpriPiezas,panelImprimir">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
            </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelTextPiezas">
              <h:outputText value="Piezas enviadas a patologia" styleClass="labelTextOblig"
                            rendered="#{descripcionQuirurgicaBean.mostrarAnatomiaPatologica}"/>
                             <h:panelGroup id="panelPiezasPatologia">
              <h:inputText id="idPiezas" style="width:300px" maxlength="200" immediate="true"
                           value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcpiezapatol}" required="false"
                           rendered="#{descripcionQuirurgicaBean.mostrarAnatomiaPatologica}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="idPiezas" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
                            
            </h:panelGroup>
         </h:panelGrid>
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="80%%"
                       rowClasses="labelText,labelTextInfo" id="tablePiezasSangr">
           
            <!-- Este es el que se oculta y muestra -->
        
             <h:panelGroup id="panelSnagr">
              <h:outputText value="Sangrado" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuSangrado" immediate="true"
                                    value="#{descripcionQuirurgicaBean.detalleDescripcion.hddctienesangr}"
                                    valueChangeListener="#{descripcionQuirurgicaBean.setHddctienesangr}">
                    <f:selectItems value="#{descripcionQuirurgicaBean.lstOpciones}"/>
                    <a4j:support id="supportMnuSangrado" event="onclick"
                                 action="#{descripcionQuirurgicaBean.changeSangrado}"
                                 reRender="panelTextCantidad,panelCantidadSangrado,panelCuantificado">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuSangrado" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelCuantificado">
              <h:outputText value="Cuantificado" styleClass="labelTextOblig" rendered="#{descripcionQuirurgicaBean.mostrarSangrado}"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuCuantificado" immediate="true" required="true" rendered="#{descripcionQuirurgicaBean.mostrarSangrado}"
                                    value="#{descripcionQuirurgicaBean.detalleDescripcion.hddccuantifi}"
                                    valueChangeListener="#{descripcionQuirurgicaBean.setHddccuantifi}">
                    <f:selectItems value="#{descripcionQuirurgicaBean.lstOpciones}"/>
                     <a4j:support id="supportMnuSangradoc" event="onclick"
                                 action="#{descripcionQuirurgicaBean.changeCuantSangrado}"
                                 reRender="panelTextCantidad,panelCantidadSangrado,panelCuantificado">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCuantificado" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelTextCantidad">
              <h:outputText value="Cantidad Aproximada(mL)" styleClass="labelTextOblig"
                            rendered="#{descripcionQuirurgicaBean.mostrarSangradoCuanti}"/>
              <h:panelGroup id="panelCantidadSangrado">
                <h:inputText id="idCantidadSangrado" maxlength="4" style="width:50px" immediate="true"
                             rendered="#{descripcionQuirurgicaBean.mostrarSangradoCuanti}"
                             value="#{descripcionQuirurgicaBean.detalleDescripcion.hddnsangraprox}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="idCantidadSangrado" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
          </h:panelGrid>
          
          <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%"
                       rowClasses="labelText,labelTextInfo" id="tableDiuresis">
            <h:panelGroup id="panelDiure">
              <h:outputText value="Diuresis" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                      <h:selectOneRadio id="mnuDiuresis" immediate="true"
                                        value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcanotardiur}"
                                        valueChangeListener="#{descripcionQuirurgicaBean.setHddcanotardiur}">
                        <f:selectItems value="#{descripcionQuirurgicaBean.lstOpciones}"/>
                        <a4j:support id="supportMnuDiuresis" event="onclick" immediate="true"
                                     action="#{descripcionQuirurgicaBean.changeDiuresis}"
                                     reRender="panelTextCantidadDiresis,panelTextAspectos,panelTextGrado,panelCantidadDiuresis,panelMnuAspectos,panelMenuGrado">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                    </a4j:region>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuDiuresis" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
              </h:panelGroup>
            </h:panelGroup>
           <h:panelGroup id="panelCuantificadoDiure" rendered="false">
              <h:outputText value="Cuantificado" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuCuantificadoDiur" immediate="true" required="true"
                                    value="#{descripcionQuirurgicaBean.detalleDescripcion.hddccuantidiure}"
                                    valueChangeListener="#{descripcionQuirurgicaBean.setHddccuantidiure}">
                    <f:selectItems value="#{descripcionQuirurgicaBean.lstOpciones}"/>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCuantificadoDiur" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelTextCantidadDiresis">
              <h:outputText value="Cantidad (mL)" styleClass="labelTextOblig"
                            rendered="#{descripcionQuirurgicaBean.mostrarDiuresis}"/>
              <h:panelGroup id="panelCantidadDiuresis">
                <h:panelGrid columns="2" id="panelCant">
                  <h:panelGroup>
                    <h:inputText id="idCantidadDiuresis" maxlength="4" style="width:50px" immediate="true"
                                 rendered="#{descripcionQuirurgicaBean.mostrarDiuresis}"
                                 value="#{descripcionQuirurgicaBean.detalleDescripcion.hddncantidadiu}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="idCantidadDiuresis" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="ml" styleClass="labelTextOblig"
                                rendered="#{descripcionQuirurgicaBean.mostrarDiuresis}"/>
                </h:panelGrid>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelTextAspectos">
              <h:outputText value="Aspectos" styleClass="labelTextOblig"
                            rendered="#{descripcionQuirurgicaBean.mostrarDiuresis}"/>
              <h:panelGroup id="panelMnuAspectos">
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAspectos" immediate="true"
                                    rendered="#{descripcionQuirurgicaBean.mostrarDiuresis}"
                                    value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcaspectodiu}"
                                    valueChangeListener="#{descripcionQuirurgicaBean.setHddcaspectodiu}">
                    <f:selectItems value="#{descripcionQuirurgicaBean.lstAspectos}"/>
                    <a4j:support id="supportMnuAspectos" event="onclick"
                                 action="#{descripcionQuirurgicaBean.changeAspectos}"
                                 reRender="panelTextGrado,panelMenuGrado">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAspectos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelTextGrado">
              <h:outputText value="Grado" styleClass="labelTextOblig"
                            rendered="#{descripcionQuirurgicaBean.mostrarDiuresis && descripcionQuirurgicaBean.renderGrado}"/>
              <h:panelGroup id="panelMenuGrado">
                <h:selectOneMenu id="mnuGrado"
                                 rendered="#{descripcionQuirurgicaBean.mostrarDiuresis && descripcionQuirurgicaBean.renderGrado}"
                                 value="#{descripcionQuirurgicaBean.detalleDescripcion.hddcgradohemar}">
                  <f:selectItems value="#{descripcionQuirurgicaBean.lstGradoHematurica}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuGrado" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
         <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonGuardarDescripcion" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                             onclick="if (!confirm(\'�Realmente desea Crear la Descripci�n Quirurgica\')) return false"
                             action="#{descripcionQuirurgicaBean.guardarDescripcion}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
     </t:panelTab>
      <t:panelTab id="panelTabBuscadorDescripcionQuirurgicaCie10" label="Bucar Diagnosticos"
                  rendered="#{descripcionQuirurgicaBean.mostrarCie10 && !descripcionQuirurgicaBean.renderPlantilla}">
        <a4j:region id="regionDescripcionQuirurgicaCie10" renderRegionOnly="false">
          <a4j:status id="statusButton" for="regionDescripcionQuirurgicaCie10">
            <f:facet name="start">
              <t:div id="chargingDescripcionQuirurgicaCie10" styleClass="loading">
                <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                  <h:outputText value="Procesando..."/>
                  <h:outputText value="Por favor espere."/>
                </h:panelGrid>
              </t:div>
            </f:facet>
            <f:facet name="stop"/>
          </a4j:status>
          <s:fieldset legend="Cie10" id="fieldSetDescripcionQuirurgicaCie10" styleClass="fieldset">
            <jsp:include page="/pages/clinico/comunes/buscador/buscadorCie10Procedimiento.jsp" flush="true"/>
            <h:panelGrid id="panelGridDescripcionQuirurgicaCie10Botones" width="100%"
                         columnClasses="columnaBotonesCentrados" dir="RTL">
              <t:htmlTag value="br"/>
              <h:panelGroup id="panelGroupDescripcionQuirurgicaCie10Botones1">
                <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                   action="#{descripcionQuirurgicaBean.aceptarDiagnostico}"
                                   reRender="panelGridDescripcionQuirurgicaTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
        </a4j:region>
      </t:panelTab>
      <t:panelTab id="panelBuscadorPlantillaDescripcionQuirurgica" label="Buscar Plantillas"
                  rendered="#{!descripcionQuirurgicaBean.mostrarCie10 && descripcionQuirurgicaBean.renderPlantilla}">
        <a4j:region id="regionBuscadorPlantillaDescripcionQuirurgica" renderRegionOnly="false">
          <a4j:status for="regionBuscadorPlantillaDescripcionQuirurgica">
            <f:facet name="start">
              <t:div id="chargingBuscadorPlantillaDescripcionQuirurgica" styleClass="loading">
                <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                  <h:outputText value="Procesando..."/>
                  <h:outputText value="Por favor espere."/>
                </h:panelGrid>
              </t:div>
            </f:facet>
            <f:facet name="stop"/>
          </a4j:status>
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillasCirugia.jsp" flush="true"/>
          <h:panelGrid id="panelDescripcionQuirurgicaBotones" width="100%" columnClasses="columnaBotonesCentrados"
                       dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupBotonesPlantillaDescripcionQuirurgica">
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                 action="#{descripcionQuirurgicaBean.aceptarPlantilla}"
                                 reRender="panelGridDescripcionQuirurgicaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </a4j:region>
      </t:panelTab>
      <t:panelTab id="panelBuscadorServicio" label="Buscar Servicio"
                  rendered="#{descripcionQuirurgicaBean.renderBuscadorServicio}">
        <a4j:region id="regionServicio" renderRegionOnly="false">
          <a4j:status id="statusButton" for="regionServicio">
            <f:facet name="start">
              <t:div id="chargingServicio" styleClass="loading">
                <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                  <h:outputText value="Procesando..."/>
                  <h:outputText value="Por favor espere."/>
                </h:panelGrid>
              </t:div>
            </f:facet>
            <f:facet name="stop"/>
          </a4j:status>
          <a4j:region renderRegionOnly="false">
            <jsp:include page="/pages/clinico/comunes/buscador/buscadorServicios.jsp" flush="true"/>
          </a4j:region>
        </a4j:region>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonServicio"
                     columnClasses="panelGridBoton">
          <h:panelGroup>
          <a4j:region renderRegionOnly="false">
            <a4j:commandButton value="Aceptar Servicio" styleClass="btn btn btn-success"
            reRender="panelGridDescripcionQuirurgicaTab"
                             action="#{descripcionQuirurgicaBean.aceptarServicio}"/>
                             </a4j:region>
          </h:panelGroup>
        </h:panelGrid>
      </t:panelTab>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionDescripcionQuirurgicaMsg" ajaxRendered="true">
          <t:messages id="msgDescripcionQuirurgicaMsg" showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </t:panelTabbedPane>
      <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
<f:subview id="generarRecomendaciones" rendered="#{descripcionQuirurgicaBean.generoReporte}">
  <f:verbatim>
    <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
  </f:verbatim>
</f:subview>
  </h:panelGrid>
</a4j:region>