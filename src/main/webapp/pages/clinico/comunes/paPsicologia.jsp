<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="registrarNotaAclaratoriaForm">
  <a4j:region id="bodyRegionRegistrarNotaAclaratoria">
    <a4j:status id="statusButton" for="bodyRegionRegistrarNotaAclaratoria">
      <f:facet name="start">
        <t:div id="chargindRegistrarNotaAclaratoria" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="tableContentTabsRegistrarNotaAclaratoria" styleClass="tabContainerRegistrarNotaAclaratoria">
      <t:htmlTag value="br"/>
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
                             value="#{consultarFoliosPAPsicologiaBean.usuario.husetipoiden}">
              <f:selectItems value="#{consultarFoliosPAPsicologiaBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosPAPsicologiaBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuario"
                        value="#{consultarFoliosPAPsicologiaBean.usuario.huslnumero}"/>
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
            <h:outputText value="#{consultarFoliosPAPsicologiaBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosPAPsicologiaBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido"
                          value="#{consultarFoliosPAPsicologiaBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosPAPsicologiaBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosPAPsicologiaBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosPAPsicologiaBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true"
                             value="#{consultarFoliosPAPsicologiaBean.usuario.husesexo}">
              <f:selectItems value="#{consultarFoliosPAPsicologiaBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{consultarFoliosPAPsicologiaBean.usuario.huseestadcivil}">
              <f:selectItems value="#{consultarFoliosPAPsicologiaBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonConsultarUsuario"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionCOnsultarHistoria"
                             ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonBuscarHistoria"
                         id="msgInformationConsultarHistoria" errorClass="error"
                         infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
         </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Registrar Primerios Auxilios Psicologia" id="fieldRegistrarNotaAclaratoria" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegistrarNotaAclaratoria" rowClasses="labelText">
          <h:outputText value="Observacion" styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:panelGroup>
            <h:inputTextarea id="textNotaAclaratoria" required="true" value="#{registrarPAPsicologiaBean.observacion}" 
                             style="width: 95%;height: 250px;" />
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textNotaAclaratoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
       
      </s:fieldset>
    </h:panelGrid>
     
    <h:panelGrid columns="1" border="0" cellpadding="5" cellspacing="0" width="100%"
                 id="panelBotonRegistrarNotaAclaratoria" columnClasses="panelGridBotones">
     
        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                         action="#{registrarPAPsicologiaBean.aceptar}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
           <h:outputText value=" "/>

           
          <h:commandButton value="Cierre" styleClass="boton_fieldset"
                         action="#{registrarPAPsicologiaBean.volverPrincipal}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
     
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMsgFolioCito" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationMsgPapsicologia" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <f:subview id="generarPapPsicologia" rendered="#{registrarPAPsicologiaBean.notaRealizada}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </h:panelGrid>
  </a4j:region>
</a4j:form>