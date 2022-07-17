<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="formConsultarProgramacion">
  <a4j:region id="regionConsultarProgramacion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionConsultarProgramacion">
      <f:facet name="start">
        <t:div id="chargingConsultarProgramacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Consultar Programaci�n " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="tableContentTabsConsultarProgramacion" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="tabbedPaneConsultarProgramacion" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <s:fieldset legend="Busqueda Consulta" id="fieldDatosConsulta" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%"
                       id="tableContentTabsListaUsuario" columnClasses="labelText,labelTextInfo">
            <h:outputText value="Se�or(a): "/>
            <h:outputText id="otnomDoctor" value="#{consultarProgramacionCirugiaBean.usuarioSystem.curcnombre}"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value="Fecha: "/>
            <t:inputCalendar id="fechaConsulta" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{consultarProgramacionCirugiaBean.fechaActual}"
                             popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                             disabled="false" maxlength="11" size="11" immediate="true"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" valueChangeListener="#{consultarProgramacionCirugiaBean.setFechaActual}"
                             required="true"></t:inputCalendar>
            <h:outputText value="Sala Quirofano "/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuSala" value="#{consultarProgramacionCirugiaBean.sala}" required="true"
                               styleClass="dropdown-toggle, input-medium">
                <f:selectItems value="#{consultarProgramacionCirugiaBean.lstSalasCirugia}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuSala" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonReporteConsultasAtendidas" columnClasses="panelGridBotones">
          <h:panelGroup>
            <a4j:commandButton value="Consultar Programaci�n" styleClass="btn btn btn-success"
                               reRender="tableContentTabsConsultarProgramacion"
                               action="#{consultarProgramacionCirugiaBean.consultarProgramacion}">
              <a4j:support event="onclick" status="statusButton"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
        <s:fieldset legend="Cirugias Programadas " id="fieldSetConsultarCirugias" styleClass="fieldset_dataTable">
        
              <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true"
                 displayAtDistanceX="-155" displayAtDistanceY="10" rendered="#{not empty consultarProgramacionCirugiaBean.lstCirugiasCompleta}">
          <h:commandLink id="imprimirReporteProgramacionDetallado" immediate="true" value="Visualizar Programaci�n Excel"
                         action="#{consultarProgramacionCirugiaBean.generarReporteExcel}">
            <t:graphicImage title="Reporte Programaci�n Excel" alt="" border="0" url="/comun/imagenes/xls.gif"/>
          </h:commandLink>
          <f:facet name="popup">
          
          
            <f:subview id="generarReporteLiquidosEnfermeriaExcel" 
         rendered="#{consultarProgramacionCirugiaBean.generoReporte}">
                 <f:verbatim>
            <script type="text/javascript" language="JavaScript">
            function enviar(){
           window.location="<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
           }
        </script>
            <a href="javascript:enviar()">
              <img src="../../../../comun/imagenes/xls.png" height="100" width="100" alt="Descargue"></img>
              <br/>
              Descargar Archivo
            </a>
          </f:verbatim>
            </f:subview>
      
            <h:panelGroup>
              <h:panelGrid columns="2" style="text-align:left;">
                <h:outputText value="Reporte Programaci�n"/>
              </h:panelGrid>
            </h:panelGroup>
          </f:facet>
        </t:popup>
          <h:panelGrid columns="1" id="panelGridConsultar"
                       rendered="#{empty consultarProgramacionCirugiaBean.lstCirugiasCompleta}">
            <t:messages id="msgconsultarProgramacionCirugia" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableContentTabsConsultar"
                       rendered="#{not empty consultarProgramacionCirugiaBean.lstCirugiasCompleta}"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           value="#{consultarProgramacionCirugiaBean.lstCirugiasCompleta}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtBucarUsuarios">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Procedimiento"/>
                  </f:facet>
                  <h:outputText value="#{item.nombreServicio}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Hora"/>
                  </f:facet>
                  <h:outputText value="Ini: "/>
                  <h:outputText value="#{item.hcpdfechacirug}">
                    <f:convertDateTime pattern="hh:mm"/>
                  </h:outputText>
                  <h:outputText value=" Fin: "/>
                  <h:outputText value="#{item.hcpdfechfincir}">
                    <f:convertDateTime pattern="hh:mm"/>
                  </h:outputText>
                </h:column>
                  <h:column>
                  <f:facet name="header">
                    <h:outputText value="No Identificaci�n"/>
                  </f:facet>
                  <h:outputText value="#{item.hcplusuario.husanumeiden}"/>
                </h:column>
                      <h:column>
                  <f:facet name="header">
                    <h:outputText value="Edad"/>
                  </f:facet>
                  <h:outputText value="#{item.edad}"/>
                </h:column>
                
                  <h:column>
                  <f:facet name="header">
                    <h:outputText value="Asegurador"/>
                  </f:facet>
                  <h:outputText value="#{item.asegurador}"/>
                </h:column>
                
                  <h:column>
                  <f:facet name="header">
                    <h:outputText value="Telefono"/>
                  </f:facet>
                  <h:outputText value="#{item.telefono}"/>
                </h:column>
                
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre Paciente"/>
                  </f:facet>
                  <h:outputText value="#{item.hcplusuario.huscprimernomb} #{item.hcplusuario.huscprimerapel}"/>
                </h:column>
              
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Ayudantia"/>
                  </f:facet>
                  <h:outputText value="#{(item.hcpctipoayudan == \'S\') ? \'SI\' : \'NO\'}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Profesional Cirujano"/>
                  </f:facet>
                  <h:outputText value="#{item.nombreMedico}"/>
                </h:column>
                
                 <h:column>
                  <f:facet name="header">
                    <h:outputText value="Tipo Anestesia"/>
                  </f:facet>
                  <h:outputText value="#{item.anestesia}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Anestesia"/>
                  </f:facet>
                  <h:outputText value="#{item.hcpcdescranest} #{item.tipoSedacion}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Anestesiologo"/>
                  </f:facet>
                  <h:outputText value="#{item.nombreAnestesiologo}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Estancia"/>
                  </f:facet>
                  <h:outputText value="#{(item.hcpcdescrestan == \'S\') ? \'SI\' : \'NO\'}"/>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtBucarUsuarios" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
     
        
        
       
        
        
      </t:panelTabbedPane>
      <f:subview id="generarReporteLiquidosEnfermeria" rendered="#{consultarProgramacionCirugiaBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
       
    </h:panelGrid>
  </a4j:region>
</a4j:form>