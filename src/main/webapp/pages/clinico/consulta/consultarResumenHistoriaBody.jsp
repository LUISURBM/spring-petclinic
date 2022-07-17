<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarResumenHistoriaForm">
 <a4j:region id="bodyRegionConsultarResumen">
    <a4j:status id = "statusButton" for="bodyRegionConsultarResumen">
      <f:facet name="start">
        <t:div id="chargindConsultarResumen" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableConsultarResumen" border="0" cellpadding="0"
                 cellspacing="0" width="100%" styleClass="td_ubicador">
      <h:outputText value="Consultar Resumen Historia " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="tableContentConsultarResumen"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuario"
                  styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionInfoConsulta"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificaci�n"/>
          <h:outputText value=" Numero Identificaci�n"/>
          <h:outputText value="N�mero Usuario"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                             value="#{consultarFoliosBean.usuario.husetipoiden}">
              <f:selectItems value="#{consultarFoliosBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuario"
                        value="#{consultarFoliosBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosNombre"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido"
                          value="#{consultarFoliosBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true"
                             value="#{consultarFoliosBean.usuario.husesexo}">
              <f:selectItems value="#{consultarFoliosBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{consultarFoliosBean.usuario.huseestadcivil}">
              <f:selectItems value="#{consultarFoliosBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
     
      </s:fieldset>
       <s:fieldset legend="Fecha Resumen" id="fieldSetInfoCriteriosBusqueda"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelFechasResumen"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Fecha Inicial"/>
          <h:outputText value="Fecha Final"/>
          <h:panelGroup>
            <t:inputCalendar id="fechaInicial" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                             title="Formato: dd/mm/yyyy" immediate="true" currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             value="#{consultarFoliosBean.fechaInicial}" popupTodayString="Hoy" popupWeekString="Semana"
                             popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" required="true"></t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaInicial" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <t:inputCalendar id="fechaFinal" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                             title="Formato: dd/mm/yyyy" immediate="true" currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{consultarFoliosBean.fechaFinal}"
                             popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaFinal" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <t:htmlTag value="br"/>
          <h:commandButton value="Consultar Resumen Historia" action="#{consultarFoliosBean.imprimirResumen}"
                           styleClass="boton_fieldset">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGrid>
      </s:fieldset>
  
    </h:panelGrid>
        <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajesResumenHistoria" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInfResumenHistoria" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    
    
          <h:panelGrid>
        <h:commandLink action="#{consultarFoliosBean.volverConsulta}" immediate="true">
          <t:graphicImage alt=""  border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </h:panelGrid>
  </a4j:region>
  
     <f:subview id="generarHistoriaPDF" >
            <h:panelGrid id = "panelGridGenerarHistoriaPDF" rendered="#{consultarFoliosBean.generoHistoria}">
      
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
          </h:panelGrid>
    </f:subview>
</a4j:form>
