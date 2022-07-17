<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridInformeMamografiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneInformeMamografia"
                       selectedIndex="#{informeMamografiaBean.selectIndex}"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabInformeMamografia" label="Informe Mamografia">
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridInformeMamografiaContainer"
                       styleClass="tabContainer">
   <s:fieldset legend="Informe Mamografia" id="fieldInformeMamografia" 
                        styleClass="fieldset">
                        
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeMamografia" 
               rowClasses="labelText,labelTextInfo">
               
               <h:outputText value = "N�mero de Mamografia"  styleClass="labelTextOblig"/>
               <h:outputText value = "Medico que remite"  styleClass="labelTextOblig"/>
               <h:panelGroup>
                <h:inputText id = "itNumeroMamografia" 
                required="true" style="width:50px" maxlength="9"
                onkeydown="return blockEnter(event);"
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himnnumero}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumeroMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
               </h:panelGroup>
                <h:panelGroup>
                <h:inputText id = "itMedicoRemiteMamografia" required="true" 
                  style="width:150px" maxlength="80"
                  onkeydown="return blockEnter(event);"
                  disabled="#{informeMamografiaBean.modoconsulta}"
                  value= "#{informeMamografiaBean.informe.himcmedicoremi}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itMedicoRemiteMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
  </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeMamografia3" 
               rowClasses="labelText,labelTextInfo">
                 <h:outputText value = "Datos Clinicos Relevantes"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itDatosClinicosRelevantesMamografia" required="true" style="width:600px"
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcdatosclire}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDatosClinicosRelevantesMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
                <h:outputText value = "Informe Mamografia"  styleClass="labelTextOblig"/>
                 
              
              
             <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{informeMamografiaBean.mostrarBuscadorPlantilla}" immediate="true"
                 reRender="panelGridInformeMamografiaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="itInformeMamografia" immediate="true"
                            onkeydown="return blockEnter(event);" 
                            binding="#{informeMamografiaBean.itInforme}"
                            disabled="#{informeMamografiaBean.modoconsulta}"
                            value= "#{informeMamografiaBean.informe.himcinformamog}"
                            style="width:600px">
             </h:inputTextarea>
             
             <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformeMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
            </h:panelGrid>
              
              
               <h:outputText value = "Dosis Entrada a Superficie"  styleClass="labelTextOblig"/>
                <h:panelGroup>
                <h:inputText id = "itDosisMamografia" required="true" style="width:50px" maxlength="1"
                onkeydown="return blockEnter(event);"
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himndosisentra}"/>
                <h:outputText value = " miliGreys (mGy)"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDosisMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
              <h:outputText value = "Informe como tal"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itInformeComoTalMamografia" required="true" style="width:600px" 
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcinformetal}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformeComoTalMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
         <h:outputText value = "Opini�n"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itOpinionMamografia" required="true" style="width:600px" 
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcopinion}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itOpinionMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
               
        </h:panelGrid>
        
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeMamografico" 
               rowClasses="labelText,labelTextInfo">
                 <h:outputText value = "Tipo Birads"  styleClass="labelTextOblig"/>
                 <h:outputText value = "Recomendaciones"  styleClass="labelTextOblig"/>
                       <h:panelGroup>
            <h:selectOneMenu id="menuTipoBiradsMamografia" required="true" 
                            onkeydown="return blockEnter(event);"
                            disabled="#{informeMamografiaBean.modoconsulta}"
                             value="#{informeMamografiaBean.informe.himctipobirads}">
              <f:selectItems value="#{informeMamografiaBean.lstTipoBirads}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuTipoBiradsMamografia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
                 
                  <h:panelGroup>
                <h:inputTextarea id = "itRecomendacionesMamografia" required="true" style="width:600px" 
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcrecomendac}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itRecomendacionesMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
               
               </h:panelGrid>
   <f:subview id="generarInformeMamografia" rendered="#{informeMamografiaBean.generoInforme}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelBotonesInformeMamografia" dir="RTL"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Aceptar" styleClass="boton_fieldset"
                           disabled="#{informeMamografiaBean.modoconsulta}"
                           action="#{informeMamografiaBean.generarMamografia}"/>
                           <a4j:support event="onclick" status="statusButton"/>
      </h:panelGroup>
    </h:panelGrid>
  
  </s:fieldset>
  </h:panelGrid>
      <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionInformeMamografiaMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationInformeMamografiaMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
</t:panelTab>

 <t:panelTab id="panelBuscadorMamografia" label="Buscar Plantillas" rendered="#{informeMamografiaBean.renderBuscador}">
      <a4j:region id="regionBuscadorMamografia" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionBuscadorMamografia">
          <f:facet name="start">
            <t:div id="chargingBuscadorMamografia" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesMamografia" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotones1Mamografia">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset" 
              action="#{informeMamografiaBean.aceptarPlantilla}" 
                reRender="panelGridInformeMamografiaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>

</t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>

</h:panelGrid>