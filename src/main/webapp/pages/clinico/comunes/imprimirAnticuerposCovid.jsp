<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridPruebaCovidAnticuerpoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPanePruebaCovidAnticuerpo" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPruebaCovidAnticuerpo" label="Prueba de Detecci�n de Anticuerpos COVID-19">
      <s:fieldset legend="Datos Adicionales" id="fieldSetPruebaCovidAnticuerpo" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosPruebaCovidAnticuerpo" rowClasses="labelTextInfo,labelTextInfo">
          <h:outputText value="Cerco epidemiol�gico" styleClass="labelTextOblig"/>
           <h:outputText value="#{(pruebasAnticuerposCovidBean.covidAnticuerpo.hpaccercepid== \'N\' ? \'No\' : \'Si\')}"/>
          
          <h:outputText value="Trabajador de la salud " styleClass="labelTextOblig"/>
           <h:outputText value="#{(pruebasAnticuerposCovidBean.covidAnticuerpo.hpactrabsalud== \'N\' ? \'No\' : \'Si\')}"/>
          
          <h:outputText value="�ha tenido contacto estrecho en los �ltimos 14 d�as?" styleClass="labelTextOblig"/>
           <h:outputText value="#{(pruebasAnticuerposCovidBean.covidAnticuerpo.hpaccontadias== \'N\' ? \'No\' : \'Si\')}"/>
          
          <h:outputText value="�El paciente ha tenido s�ntomas?" styleClass="labelTextOblig"/>
           <h:outputText value="#{(pruebasAnticuerposCovidBean.covidAnticuerpo.hpacsintopaci== \'N\' ? \'No\' : \'Si\')}"/>
          
          <h:outputText value="Fecha de inicio de s�ntomas:" styleClass="labelTextOblig"/>
          <h:outputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpadfecsinto}"/>
          
          <h:outputText value="N�mero de d�as de evoluci�n de los s�ntomas " styleClass="labelTextOblig"/>
          <h:outputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpannumesintevol}"/>
           </h:panelGrid>
           </s:fieldset>
        <s:fieldset legend="Condici�n de realizaci�n de la prueba" id="fieldSetCondicionCovidAnticuerpo" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelCondicionPruebaCovidAnticuerpo" rowClasses="labelTextInfo,labelTextInfo">
          <h:outputText value="Lugar donde se toma la muestra" styleClass="labelTextOblig"/>
         <h:outputText value="#{(pruebasAnticuerposCovidBean.covidAnticuerpo.hpaclugatoma== \'CL\' ? \'Clinica\' : pruebasAnticuerposCovidBean.covidAnticuerpo.hpaclugatoma==\'BE\' ? \'Brigada Extramural\' : \'Domicilio Paciente\')}"/>
         
          <h:outputText value="Temperatura ambiental" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:panelGrid columns="2" cellpadding="0" cellspacing="0" width="20%" id="panelTemperatura">
             <h:outputText  value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpantempambi}"/>
              <h:outputLabel value="c�"/>
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
        <s:fieldset legend="Datos de la prueba r�pida" id="fieldSetDatosPRCovidAnticuerpo" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosPRPruebaCovidAnticuerpo" rowClasses="labelTextInfo,labelTextInfo">
          <h:outputText value="Marca" styleClass="labelTextOblig"/>
           <h:outputText value="ONSITE RAPID TEST CTK BIOTECH"/>
            
          <h:outputText value="Lote" styleClass="labelTextOblig"/>
           <h:outputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpaclote}"/>
            
          <h:outputText value="Registro Invima" styleClass="labelTextOblig"/>
          <h:outputText value="INVIMA 2020RD-0006148"/>
          
          <h:outputText value="Fecha de fabricaci�n" styleClass="labelTextOblig"/>
           <h:outputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpadfechfabr}"/>
            
          <h:outputText value="Fecha de vencimiento" styleClass="labelTextOblig"/>
          <h:outputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpadfechvenci}"/>
            
          <h:outputText value="Resultado" styleClass="labelTextOblig"/>
         <h:outputText value="#{(pruebasAnticuerposCovidBean.covidAnticuerpo.hpacresultado == \'N\' ? \'Negativo\' : pruebasAnticuerposCovidBean.covidAnticuerpo.hpacresultado==\'P\' ? \'Positivo\' : \'Indeterminado\')}"/>
         
          <h:panelGroup id="groupTipoAntText">
          <h:outputText  value="Tipo de Ant�geno " styleClass="labelTextOblig"  rendered="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpacresultado == 'P'}"/>
          </h:panelGroup>
           <h:panelGroup id="groupTipoAntSelect" >
          <h:outputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpactipoantig}"  rendered="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpacresultado == 'P'}"/>
          </h:panelGroup>
          <h:outputText value="Observaciones" styleClass="labelTextOblig"/>
            <h:outputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpacobserv}"/>
            
          <h:outputText value="Nombre del profesional" styleClass="labelTextOblig"/>
           <h:outputText value="#{pruebasAnticuerposCovidBean.nombreProfesional}" />
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonesAdministrarMedicamento" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Imprimir" styleClass="boton_fieldset" 
                               action="#{pruebasAnticuerposCovidBean.imprimirResumen}">
                <a4j:support event="onclick" status="statusButton"/> 
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
 <f:subview id="generarPapPsicologia" rendered="#{pruebasAnticuerposCovidBean.pruebaRealizada}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
</h:panelGrid>