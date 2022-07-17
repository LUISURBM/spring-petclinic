<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="net.sf.jasperreports.engine.JasperPrint,net.sf.jasperreports.engine.JRExporterParameter,net.sf.jasperreports.engine.JRExporter"%>
<%@ page import="net.sf.jasperreports.engine.export.JRHtmlExporter,net.sf.jasperreports.engine.export.JRHtmlExporterParameter,net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@ page import="net.sf.jasperreports.j2ee.servlets.ImageServlet,net.sf.jasperreports.j2ee.servlets.BaseHttpServlet,java.io.PrintWriter,java.io.OutputStream,java.util.HashMap,java.util.Map"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarAntecedentesForm">
 <input type="hidden" name="pagina"/>
 <input type="hidden" name="accion"/>
  <a4j:region id="bodyRegionAntecedentes">
    <a4j:status id="statusButton" for="bodyRegionAntecedentes">
      <f:facet name="start">
        <t:div id="chargindConsultarAntecedentes" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableConsultarAntecedentes" border="0"
                 cellpadding="0" cellspacing="0" width="100%"
                 styleClass="td_ubicador">
      <h:outputText value="Consultar Antecedentes Usuario "
                    id="infoUbicationAntecedentes"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="tableContentConsultarAntecedentes"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario" id="fieldSetInfoAntecedentes"
                  styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionAntecedentes"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificaci�n"/>
          <h:outputText value=" Numero Identificaci�n"/>
          <h:outputText value="N�mero Usuario"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIdeAntecedentes" required="true"
                             disabled="true"
                             value="#{consultarAntecedentesBean.usuario.husetipoiden}">
              <f:selectItems value="#{consultarAntecedentesBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIdeAntecedentes" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{consultarAntecedentesBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuarioAntecedentes"
                        value="#{consultarAntecedentesBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosNombreAntecedentes"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{consultarAntecedentesBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarAntecedentesBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido"
                          value="#{consultarAntecedentesBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarAntecedentesBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{consultarAntecedentesBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{consultarAntecedentesBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true"
                             value="#{consultarAntecedentesBean.usuario.husesexo}">
              <f:selectItems value="#{consultarAntecedentesBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{consultarAntecedentesBean.usuario.huseestadcivil}">
              <f:selectItems value="#{consultarAntecedentesBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonConsultarAntecedentes"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionAntecedentes" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonBuscarHistoria"
                         id="msgInformationConsultarHistoria" errorClass="error"
                         infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Criterios de Busqueda" id="fieldSetCriteriosBusqueda"
                  styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionCriteriosBusqueda"
                     rowClasses="labelText,labelTextInfo">
        
        <h:outputText value= "Tipo Antecedente"/>
        
        <h:panelGroup>
        <h:selectManyCheckbox id="mnuTipoAntecedente" 
                           value ="#{consultarAntecedentesBean.lstTipoAntecedenteSelect}">
            <f:selectItems value="#{consultarAntecedentesBean.lstTipoAntecedentes}"/>
          </h:selectManyCheckbox>
           <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuTipoAntecedente" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
          
    </h:panelGrid>
  </a4j:region>
</a4j:form>


      
