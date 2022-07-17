<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>

   
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridProgramarCirugiaTab"
                 styleClass="tabContainer">
      <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneProgramarCirugia"
                         selectedIndex="#{programarCirugiaBean.selectedIndex}" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabProgramarCirugia" label="Programaci�n de Cirugia(s)"
                    rendered="#{!programarCirugiaBean.renderDisponibilidad || !programarCirugiaBean.renderFacturas}">
     <a4j:region renderRegionOnly="false"> 
          <s:fieldset legend="Cirugias Programadas" id="fieldCirugias" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugias"
                         rowClasses="labelText,labelTextInfo">
              <h:outputLabel value="Tipo de Documento" for="mnuTipDoc" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputLabel value="N�mero Documento" for="itNumDoc" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:selectOneMenu id="mnuTipDoc" value="#{programarCirugiaBean.idTipoDocumento}">
                <f:selectItem itemLabel="Seleccione una opci�n..." itemValue=""/>
                <f:selectItem itemLabel="FACTURA DE CREDITO" itemValue="2"/>
                <f:selectItem itemLabel="FACTURA DE CONTADO" itemValue="51"/>
                <f:selectItem itemLabel="COMPROBANTE MANUAL" itemValue="20"/>
              </h:selectOneMenu>
              <t:message for="mnuTipDoc" errorClass="errorMessage"/>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandButton value="Buscar" action="#{programarCirugiaBean.mostrarBuscadorFacturas}"
                                   reRender="panelGridProgramarCirugiaTab" image="/comun/imagenes/lupita.png"/>
                <h:inputText id="itNumDoc" value="#{programarCirugiaBean.numerodocumento}" size="12"/>
              </h:panelGrid>
              <t:message for="itNumDoc" styleClass="errorMessage"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta"
                         columnClasses="columnaBotonesCentrados">
              <a4j:outputPanel id="ajaxRegionMessages" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            
              <h:panelGroup>
                <a4j:commandButton value="Buscar Cirugias" action="#{programarCirugiaBean.buscadorDoc}"
                                   reRender="panelTabProgramarCirugia" styleClass="boton"/>
                <a4j:commandButton value="Nueva Factura" action="#{programarCirugiaBean.inicializarBean}"
                                   reRender="panelTabProgramarCirugia" styleClass="boton"/>
              </h:panelGroup>
           
            </h:panelGrid>
          </s:fieldset>
          </a4j:region>
          <s:fieldset legend="Lista Cirugias Facturadas" id="fieldListaCirugias" styleClass="fieldset"
                      rendered="#{not empty programarCirugiaBean.lstCirugiasFactura}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs"
                         rendered="#{not empty programarCirugiaBean.lstCirugiasFactura}" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{programarCirugiaBean.dtFacturasCirugia}"
                             value="#{programarCirugiaBean.lstCirugiasFactura}" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" rows="10"
                             id="idDtCirugias">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocservic.csvccodigo} #{item.ccocservic.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.ccontipdoc.ctdnnumero} #{item.ccontipdoc.ctdcdescri}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="N�mero Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.cconnumdoc}"/>
                  </h:column>                   
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Agregar"/>
                    </f:facet>
                    <a4j:commandLink id="agregar" immediate="true"
                    reRender="panelGridProgramarCirugiaTab"
                        action="#{programarCirugiaBean.agregarCirugia}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </a4j:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
             
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="idDtCirugias" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
                  <t:dataScroller id="scroll_2" for="idDtCirugias" rowsCountVar="rowsCount"
                                  displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                                  lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                    <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}"
                                    styleClass="standard">
                      <f:param value="#{rowsCount}"/>
                      <f:param value="#{displayedRowsCountVar}"/>
                      <f:param value="#{firstRowIndex}"/>
                      <f:param value="#{lastRowIndex}"/>
                      <f:param value="#{pageIndex}"/>
                      <f:param value="#{pageCount}"/>
                    </h:outputFormat>
                  </t:dataScroller>
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Lista Cirugias Programadas" id="fieldListaCirugiasProgramadas" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridCirugiasProgramadas"
                         rendered="#{empty programarCirugiaBean.lstCirugiasSeleccionada}">
              <h:outputText value="#{msg.msg_sin_consultar}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableContentCirugiasProgramadas"
                         rendered="#{not empty programarCirugiaBean.lstCirugiasSeleccionada}" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{programarCirugiaBean.dtFacturasProgramadas}"
                             value="#{programarCirugiaBean.lstCirugiasSeleccionada}" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" rows="10"
                             id="idDtCirugiasProgramadas">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocservic.csvccodigo} #{item.ccocservic.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.ccontipdoc.ctdnnumero} #{item.ccontipdoc.ctdcdescri}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="N�mero Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.cconnumdoc}"/>
                  </h:column>
                      <h:column>
                      <f:facet name="header">
                        <h:outputText value="Medico"/>
                      </f:facet>
                         <h:panelGroup>
                  <h:selectOneMenu id="mnuProfesionales1" required="true"
                                   value="#{item.cirujanoSelect}">
                    <f:selectItems value="#{programarCirugiaBean.lstProfesionales}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuProfesionales1" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                    </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>
                    <a4j:commandLink id="eliminar"
                                         onclick="if(!confirm(\' Desea remover esta Cirug�a ? \')){ return false; }" 
                    action="#{programarCirugiaBean.eliminarCirugia}" >
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/trash.png"/>
                    </a4j:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
          
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_3" for="idDtCirugiasProgramadas" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
                  <t:dataScroller id="scroll_4" for="idDtCirugiasProgramadas" rowsCountVar="rowsCount"
                                  displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                                  lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                    <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}"
                                    styleClass="standard">
                      <f:param value="#{rowsCount}"/>
                      <f:param value="#{displayedRowsCountVar}"/>
                      <f:param value="#{firstRowIndex}"/>
                      <f:param value="#{lastRowIndex}"/>
                      <f:param value="#{pageIndex}"/>
                      <f:param value="#{pageCount}"/>
                    </h:outputFormat>
                  </t:dataScroller>
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Programaci�n Cirugia" id="fieldProgramacionCirugia" styleClass="fieldset"
                      >
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                         rowClasses="labelText,labelTextInfo" id="tableProgramacionCirugia">
              <h:outputText value="No Sala" styleClass="labelTextOblig"/>
              <h:outputText value="Fecha Cirugia" styleClass="labelTextOblig"/>
              <h:outputText value="Hora Cirugia" styleClass="labelTextOblig"/>
              <h:outputText value="Duraci�n Cirugia" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:commandLink action="#{programarCirugiaBean.mostrarBuscador}"
                                 reRender="panelGridProgramarCirugiaTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                </a4j:commandLink>
                <h:selectOneMenu id="mnuSala" value="#{programarCirugiaBean.programacion.hcpnsalainterv}">
                  <f:selectItems value="#{programarCirugiaBean.lstSalasCirugia}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuSala" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGrid columns="2">
                <t:inputCalendar id="fechaCirugia" monthYearRowClass="yearMonthHeader" title="Formato: dd/mm/yyyy"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{programarCirugiaBean.programacion.hcpdfechacirug}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top">
                  <f:validator validatorId="dateMayorIgualValidator"/>
                </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaCirugia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraCirugia1" value="#{programarCirugiaBean.horaSelect}">
                    <f:selectItems value="#{programarCirugiaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraCirugia1" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : "/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosCirugia1" value="#{programarCirugiaBean.minutoSelect}">
                    <f:selectItems value="#{programarCirugiaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutosCirugia1" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:panelGrid columns="3">
                <h:selectOneMenu id="mnuTiempo" value="#{programarCirugiaBean.tiempoSelect}">
                  <f:selectItems value="#{programarCirugiaBean.lstDuracion}"/>
                </h:selectOneMenu>
                <h:outputText value=" Minutos"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTiempo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:outputText value="Anestesia Solicitada " styleClass="labelTextOblig"/>
              <h:outputText value="Ayudantia" styleClass="labelTextOblig"/>
              <h:outputText value="Estancia " styleClass="labelTextOblig"/>
             <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="mnuAnestesia"  immediate="true" onkeydown="return blockEnter(event);"
                                    binding="#{programarCirugiaBean.mnuAnestesia}"
                                    value="#{programarCirugiaBean.programacion.hcpctipoaneste}"
                                    valueChangeListener="#{programarCirugiaBean.setHcpctipoaneste}">
                    <f:selectItems value="#{programarCirugiaBean.lstTipoAnestesia}"/>
                    <a4j:support id="supportAnestesia" event="onclick" action="#{programarCirugiaBean.changeAnestesia}"
                                 reRender="panelGridListaAnestesiologo">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuAnestesia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGrid columns="1">
                <h:selectOneRadio id="mnuAyudantia" immediate="true" onkeydown="return blockEnter(event);"
                                    binding="#{programarCirugiaBean.mnuAyudantia}"
                                    value="#{programarCirugiaBean.programacion.hcpctipoayudan}"
                                    valueChangeListener="#{programarCirugiaBean.setHcpctipoayudan}">
                    <f:selectItems value="#{programarCirugiaBean.ltsAyudantia}"/>
                    <a4j:support id="supportAyudantia" event="onclick" immediate="true"
                    action="#{programarCirugiaBean.changeAyudantia}"
                                 reRender="panelGridListaProfesionales">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuAyudantia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGrid>
            
            
            </h:panelGrid>
    <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRevisionPorSistemas"
                       rowClasses="standardTable_ExamenFisico2,standardTable_ExamenFisico">
                       
                   
            <h:outputText value="Cabeza" styleClass="labelTextOblig"/>
            <h:selectOneRadio id="mnuCabeza" required="true" immediate="true" 
                               binding="#{motivoBean.mnuCabeza}"
                              valueChangeListener="#{motivoBean.setHrserefiecabez}"
                              value="#{motivoBean.revision.hrserefiecabez}">
              <f:selectItems value="#{motivoBean.lstRefiere}"/>
              <a4j:support id="supportmnuCabeza" action="#{motivoBean.changeCabeza}"
                           reRender="panelTextCabeza,panelInputCabeza" event="onclick" immediate="true">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCabeza" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextCabeza">
              <h:outputText value="Descripci�n" styleClass="labelTextOblig" rendered="#{motivoBean.renderCabeza}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputCabeza">
              <h:inputTextarea id="textCabeza" required="true" rendered="#{motivoBean.renderCabeza}"
                               value="#{motivoBean.revision.hrscrefiecabez}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCabeza" styleClass="errorMessage"/>
            </a4j:outputPanel>
          
          </h:panelGrid>
            
          </s:fieldset>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridListaAnestesiologo"
                       rendered="#{not empty programarCirugiaBean.lstCirugiasSeleccionada}" styleClass="tabContainer">
            <s:fieldset legend="Programaci�n Anestesiologo(s)" id="fieldProgramacionAnestesiologo" styleClass="fieldset"
                        rendered="#{programarCirugiaBean.mostrarAnestesiologo}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           rowClasses="labelText,labelTextInfo" id="tableAnestesiologos">
                <h:panelGroup>
                  <h:outputText id="otAnestesiologo" value="Anestesiologo(s)"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="otAnestesiologo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGrid columns="2">
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuAnestesiologos" value="#{programarCirugiaBean.anestesiologoSelect}">
                        <f:selectItems value="#{programarCirugiaBean.lstAnestesiologos}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuAnestesiologos" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                    <a4j:commandLink id="agregarAnestesiologo" action="#{programarCirugiaBean.agregarAnestesiologo}"
                                     reRender="tableAnestesiologosSelect,tableAnestesiologos">
                      <t:graphicImage border="0" url="/comun/imagenes/useradd.png" alt="Agregar"/>
                    </a4j:commandLink>
                  </h:panelGrid>
                </a4j:region>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                           rendered="#{programarCirugiaBean.mostrarAnestesiologo}" width="100%"
                           styleClass="tabContainer" id="tableAnestesiologosSelect">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="tableAnestesiologoSeleccionados"
                             rendered="#{not empty programarCirugiaBean.lstAnestesiologosSelect}"
                             styleClass="tabContainer">
                  <t:buffer into="#{table}">
                    <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                 binding="#{programarCirugiaBean.dtAnestesiologo}"
                                 value="#{programarCirugiaBean.lstAnestesiologosSelect}" rows="10"
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
                                         immediate="true" action="#{programarCirugiaBean.eliminarAnestesiologo}"
                                         reRender="fieldProgramacionAnestesiologo">
                          <t:graphicImage border="0" url="/comun/imagenes/userdelete.png"/>
                        </a4j:commandLink>
                      </h:column>
                    </h:dataTable>
                  </t:buffer>
                  <t:buffer into="#{tableScroller}">
                    <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                      <t:dataScroller id="scroll_anestesiologo" for="dtAnestesiologo" fastStep="10" pageCountVar="pageCount"
                                      pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                      paginatorMaxPages="9" paginatorTableClass="paginator"
                                      renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                        <f:facet name="first">
                          <t:graphicImage url="/comun/imagenes/primero.gif" border="0"/>
                        </f:facet>
                        <f:facet name="last">
                          <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0"/>
                        </f:facet>
                        <f:facet name="previous">
                          <t:graphicImage url="/comun/imagenes/anterior.gif" border="0"/>
                        </f:facet>
                        <f:facet name="next">
                          <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0"/>
                        </f:facet>
                        <f:facet name="fastforward">
                          <t:graphicImage url="/comun/imagenes/adelante.gif" border="0"/>
                        </f:facet>
                        <f:facet name="fastrewind">
                          <t:graphicImage url="/comun/imagenes/atras.gif" border="0"/>
                        </f:facet>
                      </t:dataScroller>
                    </h:panelGrid>
                  </t:buffer>
                  <h:outputText value="#{tableScroller}" escape="false"/>
                  <h:outputText value="#{table}" escape="false"/>
                  <h:outputText value="#{tableScroller}" escape="false"/>
                </h:panelGrid>
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
          
          
          
          
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridListaProfesionales"
                       rendered="#{not empty programarCirugiaBean.lstCirugiasSeleccionada}" styleClass="tabContainer">
            <s:fieldset legend="Programaci�n Profesionales Ayudantes" id="fieldProgramacionProfesionalesAyudantia" styleClass="fieldset"
                        rendered="#{programarCirugiaBean.mostrarProfesionales}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           rowClasses="labelText,labelTextInfo" id="tableProfesionales">
                <h:panelGroup>
                  <h:outputText id="otProfesional" value="Profesionales"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="otProfesional" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGrid columns="2">
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuProfesionales" value="#{programarCirugiaBean.profesionalSelect}">
                        <f:selectItems value="#{programarCirugiaBean.lstProfesionales}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuProfesionales" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                    <a4j:commandLink id="agregarProfesional" action="#{programarCirugiaBean.agregarProfesional}"
                                     reRender="tableProfesionalesSelect,tableProfesionales">
                      <t:graphicImage border="0" url="/comun/imagenes/useradd.png" alt="Agregar"/>
                    </a4j:commandLink>
                  </h:panelGrid>
                </a4j:region>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                           rendered="#{programarCirugiaBean.mostrarProfesionales}" width="100%"
                           styleClass="tabContainer" id="tableProfesionalesSelect">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="tableProfesionalesSeleccionados"
                             rendered="#{not empty programarCirugiaBean.lstProfesionalesSelect}"
                             styleClass="tabContainer">
                  <t:buffer into="#{table}">
                    <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                 binding="#{programarCirugiaBean.dtProfesional}"
                                 value="#{programarCirugiaBean.lstProfesionalesSelect}" rows="10"
                                 styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                                 footerClass="paginacion" id="dtProfesional">
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
                                         immediate="true" action="#{programarCirugiaBean.eliminarProfesional}"
                                         reRender="fieldProgramacionProfesionalesAyudantia">
                          <t:graphicImage border="0" url="/comun/imagenes/userdelete.png"/>
                        </a4j:commandLink>
                      </h:column>
                    </h:dataTable>
                  </t:buffer>
                  <t:buffer into="#{tableScroller}">
                    <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                      <t:dataScroller id="scroll_Ayudantia" for="dtProfesional" fastStep="10" pageCountVar="pageCount"
                                      pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                      paginatorMaxPages="9" paginatorTableClass="paginator"
                                      renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                        <f:facet name="first">
                          <t:graphicImage url="/comun/imagenes/primero.gif" border="0"/>
                        </f:facet>
                        <f:facet name="last">
                          <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0"/>
                        </f:facet>
                        <f:facet name="previous">
                          <t:graphicImage url="/comun/imagenes/anterior.gif" border="0"/>
                        </f:facet>
                        <f:facet name="next">
                          <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0"/>
                        </f:facet>
                        <f:facet name="fastforward">
                          <t:graphicImage url="/comun/imagenes/adelante.gif" border="0"/>
                        </f:facet>
                        <f:facet name="fastrewind">
                          <t:graphicImage url="/comun/imagenes/atras.gif" border="0"/>
                        </f:facet>
                      </t:dataScroller>
                    </h:panelGrid>
                  </t:buffer>
                  <h:outputText value="#{tableScroller}" escape="false"/>
                  <h:outputText value="#{table}" escape="false"/>
                  <h:outputText value="#{tableScroller}" escape="false"/>
                </h:panelGrid>
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
          
          
          
          
          
          
          
          
          
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesProgramacion"
                       columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Programar"
                               onclick="if (!confirm(\'�Realmente desea Programar la Cirugia \')) return false"
                               styleClass="boton_fieldset" action="#{programarCirugiaBean.programarCirugia}"/>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelBuscadorDisponibilidadSala" label="Disponibilidad Salas"
                    rendered="#{programarCirugiaBean.renderDisponibilidad}">
          <a4j:region id="regionDisponibilidad" renderRegionOnly="false">
            <a4j:status for="regionDisponibilidad">
              <f:facet name="start">
                <t:div id="chargingDisponibilidad" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <jsp:include page="/pages/clinico/comunes/buscador/buscadorDisponibilidadSala.jsp" flush="true"/>
            <h:panelGrid id="panelGridDisponibilidadBotones" width="100%" columnClasses="columnaBotonesCentrados"
                         dir="RTL">
              <t:htmlTag value="br"/>
              <h:panelGroup id="panelGroupDisponibilidadBotones1">
                <a4j:commandButton value="Volver" styleClass="btn btn btn-success" 
                    action="#{programarCirugiaBean.volver}"
                                   reRender="panelGridProgramarCirugiaTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
        
         <t:panelTab id="panelBuscadorFacturasVigentes" label="Buscador Facturas Usuario"
                    rendered="#{programarCirugiaBean.renderFacturas}">
          <a4j:region id="regionFacturasVigentes" renderRegionOnly="false">
            <a4j:status for="regionFacturasVigentes">
              <f:facet name="start">
                <t:div id="chargingFacturasVigentes" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <jsp:include page="/pages/clinico/cirugia/buscador/buscadorFacturas.jsp" flush="true"/>
            <h:panelGrid id="panelGridFacturasVigentesBotones" width="100%" 
                    columnClasses="columnaBotonesCentrados"
                         dir="RTL">
              <t:htmlTag value="br"/>
              <h:panelGroup id="panelGroupFacturasVigentesBotones1">
                <a4j:commandButton value="Aceptar Facturas" styleClass="boton_fieldset" 
                    action="#{programarCirugiaBean.aceptarFacturas}"
                                   reRender="panelGridProgramarCirugiaTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
        
        
        <a4j:outputPanel id="ajaxRegionMessagesInferior" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsInferior" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </t:panelTabbedPane>
    </h:panelGrid>
