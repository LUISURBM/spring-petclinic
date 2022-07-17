<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridInformeHisterosonografiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
   <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneInformeHisterosonografia"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       selectedIndex="#{informeHisterosonografiaBean.selectIndex}"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabInformeHisterosonografia" label="Informe Histerosonografico"
      disabled="#{informeHisterosonografiaBean.renderBuscador}">
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridInformeHisterosonografiaContainer"
                       styleClass="tabContainer">
   <s:fieldset legend="Informe Histerosonografico" id="fieldInformeHisterosonografia" 
                        styleClass="fieldset">
                        
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeHisterosonografia2" 
               rowClasses="labelText,labelTextInfo">
                 <h:outputText value = "Indicaci�n del Examen "  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itIndicacionExamenHisterosonografia" required="true" style="width:600px"
                disabled="#{informeHisterosonografiaBean.modoconsulta}"
                value= "#{informeHisterosonografiaBean.informe.himcdatosclire}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itIndicacionExamenHisterosonografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
               <h:outputText value = "Transductor utilizado"  styleClass="labelTextOblig"/>
               
        <h:panelGroup>
            <h:inputText id="itInformeTransductorHisterosonografia" onkeydown="return blockEnter(event);"
                            style="width:300px" maxlength="60"
                            required="true" disabled="#{informeHisterosonografiaBean.modoconsulta}"
                             value="#{informeHisterosonografiaBean.informe.himctransducto}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itInformeTransductorHisterosonografia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
               
           <h:outputText value = "Informe"  styleClass="labelTextOblig"/>
           
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{informeHisterosonografiaBean.mostrarBuscadorPlantilla}" 
                 immediate="true"
                 reRender="panelGridInformeHisterosonografiaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="itInformeHisterosonografia"  immediate="true"
                            onkeydown="return blockEnter(event);" 
                            binding="#{informeHisterosonografiaBean.itInforme}"
                            disabled="#{informeHisterosonografiaBean.modoconsulta}"
                            value= "#{informeHisterosonografiaBean.informe.himcinformamog}"
                            style="width:600px;height:160px">
                            <f:validateLength minimum="2"/>
              </h:inputTextarea>
             
             <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformeHisterosonografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
            </h:panelGrid>
                 
          
              
           
         <h:outputText value = "Conclusi�n"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itOpinionHisterosonografia" required="true" style="width:600px" 
                disabled="#{informeHisterosonografiaBean.modoconsulta}"
                value= "#{informeHisterosonografiaBean.informe.himcopinion}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itOpinionHisterosonografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
               
        </h:panelGrid>
        
   
   <f:subview id="generarInformeHisterosonografia" rendered="#{informeHisterosonografiaBean.generoInforme}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelBotonesInformeHisterosonografia" dir="RTL"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Aceptar" styleClass="boton_fieldset"
                           disabled="#{informeHisterosonografiaBean.modoconsulta}"
                           action="#{informeHisterosonografiaBean.generarHisterosonografia}"/>
                   <a4j:support event="onclick" status="statusButton"/>
      </h:panelGroup>
    </h:panelGrid>
  
  </s:fieldset>
  </h:panelGrid>
      <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionInformeHisterosonografiaMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationInformeHisterosonografiaMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
</t:panelTab>

  <t:panelTab id="panelBuscadorHisterosonografia" label="Buscar Plantillas" 
  rendered="#{informeHisterosonografiaBean.renderBuscador}">
      <a4j:region id="regionBuscadorHisterosonografia" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionBuscadorHisterosonografia">
          <f:facet name="start">
            <t:div id="chargingBuscadorHisterosonografia" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesHisterosonografia" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotones1Histerosonografia">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success" 
              action="#{informeHisterosonografiaBean.aceptarPlantilla}" 
                reRender="panelGridInformeHisterosonografiaTab">
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