<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formListaUsuariosEnfermeria">
  <a4j:region id="regionListaUsuariosEnfermeria" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionListaUsuariosEnfermeria">
      <f:facet name="start">
        <t:div id="chargingListaUsuariosEnfermeria" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoListaEnfermeria" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Registro de Historias >> Todas las consultas Enfermeria " id="infoUbicationEnfermeria"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsListaUsuariosEnfermeria" styleClass="tabContainer">
    
         <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="tabbedPaneListaUsuariosEnfermeria" styleClass="tabbedPane"
                                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    
        <s:fieldset legend="Busqueda Consulta" id="fieldDatosConsultaEnfermeria" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%" id="tableContentTabsListaEnfermeriaUsuario" columnClasses="labelText,labelTextInfo">
            
            <h:outputText value="Jefe: "/>
            <h:outputText id="otnomEnfermeria" value="#{listaUsuariosEnfermeriaBean.usuarioSystem.curcnombre}"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>          
            
            <h:outputText value="Fecha Consulta: "/>
            <a4j:region renderRegionOnly="false">
            <t:inputCalendar id="fechaConsultaEnfermeria" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{listaUsuariosEnfermeriaBean.fechaActual}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" disabled="false" maxlength="11" size="11" immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" valueChangeListener="#{listaUsuariosEnfermeriaBean.setFechaActual}" required="true">
              <a4j:support id="supportmnuLisEnfermeria" event="onchange" action="#{listaUsuariosEnfermeriaBean.changeConsultas}" reRender="formListaUsuariosEnfermeria">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </t:inputCalendar>
            </a4j:region>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            
          </h:panelGrid>
          
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
          <h:outputText value=" Número Identificación" rendered="#{listaUsuariosEnfermeriaBean.busquedaXCedula}"/>
          <h:outputText/>
                   <h:inputText id="itNumeroIdentificacion" maxlength="15" 
                   onkeypress="searchByEnterAndReturn(event)"
                               rendered="#{listaUsuariosEnfermeriaBean.busquedaXCedula}"
                               value="#{listaUsuariosEnfermeriaBean.numeroIdentificacion}"
                               onkeydown="return blockEnter(event);"/>
                               <a4j:commandButton value="Buscar" id="BtnBuscar"
                                     rendered="#{listaUsuariosEnfermeriaBean.busquedaXCedula}"
                                     action="#{listaUsuariosEnfermeriaBean.changeConsultas}"
                                     image="/comun/imagenes/lupita.png"
                                     reRender="formListaUsuariosEnfermeria"/>
                   
                </h:panelGrid>
          
        </s:fieldset>
        
        <t:panelTab id="panelTabListaUsuariosEnfermeria" label="Lista de Consultas">
          <t:htmlTag value="br"/>


        <!-- Consultas Agendadas  -->
        <s:fieldset legend="Mis Consultas Agendadas" id="fieldConsultasProcesoAgendas" styleClass="fieldset"
                    rendered="#{not empty listaUsuariosEnfermeriaBean.lstMisConsultasAgendadas}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableContentTabsConsultasProcesoAgendas" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                           binding="#{listaUsuariosEnfermeriaBean.dtlstMisConsultasAgendadas}"
                           value="#{listaUsuariosEnfermeriaBean.lstMisConsultasAgendadas}" styleClass="standard_table"
                           rowClasses="standardTable_Row3,standardTable_Row4" footerClass="paginacion" rows="20"
                           id="idtMisConsultasAgendas">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Hora"/>
                  </f:facet>
                  <h:outputText value="#{item.hora_agenda}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Identificación"/>
                  </f:facet>
                  <h:outputText value="#{item.id_paciente.husetipoiden} #{item.id_paciente.husanumeiden}"/>
                </h:column>
                
                 <h:column>
                  <f:facet name="header">
                    <h:outputText value="Como desea ser llamado"/>
                  </f:facet>
                  <h:outputText value="#{item.id_paciente.huscnombralter}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Paciente"/>
                  </f:facet>
                  <h:outputText value="#{item.id_paciente.huscprimernomb} #{item.id_paciente.huscprimerapel}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Servicio"/>
                  </f:facet>
                  <h:outputText value="#{item.especialidad.csvccodigo} #{item.especialidad.csvcnombre}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Subagenda"/>
                  </f:facet>
                  <h:outputText value="#{item.subagenda == 1 ? 'X' : ' '}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Atender"/>
                  </f:facet>
                  <t:commandLink id="atenderproceso" action="#{listaUsuariosEnfermeriaBean.atenderMisConsultasAgendadas}"
                         rendered="#{item.tieneConsulta}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                  </t:commandLink>
                  <h:outputText value="#{item.desConsulta}" rendered="#{!item.tieneConsulta}"/>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_procesoAgendas" for="idtMisConsultasAgendas" fastStep="10"
                                pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="pagination"
                                paginator="true" immediate="true" renderFacetsIfSinglePage="false" paginatorMaxPages="9"
                                paginatorTableClass="paginator" paginatorActiveColumnStyle="font-weight:bold;"></t:dataScroller>
                <t:dataScroller id="scroll_procesoAgendas2" for="idtMisConsultasAgendas" immediate="true"
                                rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCountVar"
                                firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex" pageCountVar="pageCount"
                                pageIndexVar="pageIndex">
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



          
        <s:fieldset legend="Mis Consultas Asignadas" id="fieldConsultasProcesoEnfermeria" styleClass="fieldset" 
               rendered="#{not empty listaUsuariosEnfermeriaBean.lstMisConsultas}">
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultasProcesoEnfermeria"
                          styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                            binding="#{listaUsuariosEnfermeriaBean.dtMisConsultas}"
                             value="#{listaUsuariosEnfermeriaBean.lstMisConsultas}"
                             styleClass="standard_table" rowClasses="standardTable_Row3,standardTable_Row4"
                             footerClass="paginacion" rows="20" id="idtMisConsultasEnfermeria">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Consulta"/>
                        </f:facet>
                        <h:outputText value="#{item.cconnumero}"/>
                    </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Hora"/>
                    </f:facet>
                    <h:outputText value="#{item.horaRegi}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Identificación"/>
                    </f:facet>
                    <h:outputText value="#{item.ccoctipide} #{item.ccoanumide}"/>
                  </h:column>
                  <h:column>
                  <f:facet name="header">
                    <h:outputText value="Como desea ser llamado"/>
                  </f:facet>
                  <h:outputText value="#{item.ccolusuario.huscnombralter}"/>
                </h:column>

                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocprinom} #{item.ccocpriape}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocservic.csvccodigo} - #{item.ccocservic.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Doc "/>
                    </f:facet>
                    <h:outputText value="#{item.ccontipdoc.ctdnnumero} - #{item.ccontipdoc.ctdcdescri}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Numero Doc"/>
                    </f:facet>
                    <h:outputText value="#{item.cconnumdoc}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Atender"/>
                    </f:facet>
                    <h:commandLink id="atenderprocesoEnfermeria"  immediate="true"  
                            action="#{listaUsuariosEnfermeriaBean.atenderMisConsultas}">
                      <t:graphicImage alt=""  border="0" url="/comun/imagenes/editar.gif"/>
                        <a4j:support event="onclick" status="statusButton"/>
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
            
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_proceso_enfermeria" for="idtMisConsultasEnfermeria" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
          </s:fieldset>
          
          
          
          <s:fieldset legend="Consultas Medicas" id="fieldAsesoriaEnfermeria" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridNoConsultasEnfermeria" rendered="#{!listaUsuariosEnfermeriaBean.existeConsulta}">
              <h:outputText value="#{listaUsuariosEnfermeriaBean.msg_sin_registros}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEnfermeria"
                         rendered="#{listaUsuariosEnfermeriaBean.existeConsulta}" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{listaUsuariosEnfermeriaBean.dtConsultas}" value="#{listaUsuariosEnfermeriaBean.lstUsuarios}"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" rows="20" id="idDtConsultasEnfermeria">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Consulta"/>
                  </f:facet>
                  <h:outputText value="#{item.cconnumero}"/>
                </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Hora"/>
                    </f:facet>
                    <h:outputText value="#{item.horaRegi}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Identificación"/>
                    </f:facet>
                    <h:outputText value="#{item.ccoctipide} #{item.ccoanumide}"/>
                  </h:column>
                   <h:column>
                  <f:facet name="header">
                    <h:outputText value="Como desea ser llamado"/>
                  </f:facet>
                  <h:outputText value="#{item.ccolusuario.huscnombralter}"/>
                </h:column>
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocprinom} #{item.ccocpriape}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocservic.csvccodigo} - #{item.ccocservic.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Doc "/>
                    </f:facet>
                    <h:outputText value="#{item.ccontipdoc.ctdnnumero} - #{item.ccontipdoc.ctdcdescri}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Numero Doc"/>
                    </f:facet>
                    <h:outputText value="#{item.cconnumdoc}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Atender"/>
                    </f:facet>
                    <h:commandLink id="atenderEnfermeria" action="#{listaUsuariosEnfermeriaBean.atenderUsuario}">
                      <t:graphicImage alt=""  border="0" url="/comun/imagenes/editar.gif"/>
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
             
             <t:buffer into="#{tableScroller}">
                                        <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                            <t:dataScroller id="scroll_enfermeria" for="idDtConsultasEnfermeria" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                                            immediate="true" renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
                                            <t:dataScroller id="scroll_2_enfermeria" for="idDtConsultasEnfermeria" immediate="true" rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCountVar"
                                                            firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                                                <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}" styleClass="standard">
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
        </t:panelTab>
      </t:panelTabbedPane>
       <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionListaUsuariosEnfermeria" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgListaUsuariosEnfermeria" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>