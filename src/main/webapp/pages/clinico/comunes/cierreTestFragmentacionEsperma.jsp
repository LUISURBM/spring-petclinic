<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFragmentacionEspermaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneFragmentacionEsperma" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabFragmentacionEsperma"
                label="TEST DE FRAGMENTACI�N ESPERM�TICA (POR DISPERSI�N DE LA CROMATINA HALOSPERM)">
      <h:panelGroup>
        <h:commandButton value="Imprimir" styleClass="boton_fieldset"
                         action="#{cierreTestFragmentacionEspermaBean.imprimirFragmentacionEsperma}">
          <a4j:support event="onclick" status="statusButton" reRender="panelTabFragmentacionEsperma"/>
        </h:commandButton>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsFragmentacionEsperma" styleClass="tabContainer">
        <s:fieldset legend="Datos del examen" id="fieldAntecedentes" styleClass="fieldset">
          <h:panelGrid columns="1">
            <h:panelGrid columns="2" cellpadding="5" cellspacing="5" border="0"  width="100%" >
              <h:outputText value="No. De examen: "/>
              <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfelnumexam}" style="margin-left:10px;"/>
              <h:outputText value="Tipo de muestra: "/>
              <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfectipomuest}"  style="margin-left:10px;"/>
              <h:outputText value="Fecha de toma de la muestra: "/>
              <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfedfechtoma}"  style="margin-left:10px;"/>
              <h:outputText value="Fecha de informe: "/>
              <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfedfechinfor}" style="margin-left:10px;"/>
              <h:outputText value="M�dico remitente: "/>
              <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfecmediremi}" style="margin-left:10px;"/>
            </h:panelGrid>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Resultado" id="fieldResultado" styleClass="fieldset">
          <h:panelGrid columns="1">
            <h:panelGroup>
              <h:panelGrid columns="2" cellpadding="5" cellspacing="5">
                <h:outputText value="N�mero de espermatozoides sin fragmentaci�n: "/>
                <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfelnesinfrag}" style="margin-left:10px;"/>
                <h:outputText value="N�mero de espermatozoides con fragmentaci�n/degradaci�n: "/>
                <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfelneconfrag}" style="margin-left:10px;"/>
                <h:outputText value="IDF"/>
                <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfenidf}" style="margin-left:10px;"></h:outputText>
              </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Observaciones" id="fieldObservaciones" styleClass="fieldset">
          <h:panelGrid columns="1">
            <h:panelGroup>
              <h:panelGrid columns="2" cellpadding="5" cellspacing="5">
                <h:outputText value="Se observa un porcentaje de: "/>
                <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfenporcentaje}" style="margin-left:10px;"></h:outputText>
                <h:outputText value="Por lo cual se considera: "/>
                <h:outputText value="#{cierreTestFragmentacionEspermaBean.chfragespe.cfecconsidera}" style="margin-left:10px;"/>
                <h:outputText value="Nombre Profesional: "/>
                <h:outputText value="#{cierreTestFragmentacionEspermaBean.prot.cpfcnombre}" style="margin-left:10px;"/>
                <h:outputText value="Registro Profesional: "/>
                <h:outputText value="#{cierreTestFragmentacionEspermaBean.prot.cpfcregmedic}" style="margin-left:10px;"/>
              </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonGuardarAntecedenteFragmentacionEsperma" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Cerrar" styleClass="boton_fieldset"
                           action="#{cierreTestFragmentacionEspermaBean.aceptar}">
            <a4j:support event="onclick" status="statusButton" reRender="panelTabFragmentacionEsperma"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
  <f:subview id="generarRecomendaciones" rendered="#{cierreTestFragmentacionEspermaBean.generoReporte}">
    <f:verbatim>
      <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
    </f:verbatim>
  </f:subview>
</h:panelGrid>