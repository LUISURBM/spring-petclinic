<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridInformeMarcacionSenoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         selectedIndex="#{informeMarcacionSenoBean.selectIndex}"
                         width="100%" id="panelTabbedPaneInformeMarcacionSeno"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabInformeMarcacionSeno"
                    label="Informe Marcaci�n Seno">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridInformeContainerMarcacion"
                       styleClass="tabContainer">
            <s:fieldset legend="Informe Marcaci�n Seno" id="fieldInformeMarcacion"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridInformeMarcacionSeno"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo de Estudio"
                              styleClass="labelTextOblig"/>
                <h:outputText value="N�mero de la Marcaci�n"
                              styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menTipoEstudioMarcacion" required="true"
                                   onkeydown="return blockEnter(event);"
                                   disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                   value="#{informeMarcacionSenoBean.informe.himctipoestudi}">
                    <f:selectItems value="#{informeMarcacionSenoBean.lstTipoEstudio}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menTipoEstudioMarcacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itNumeroMarcacionSeno" required="true"
                               onkeydown="return blockEnter(event);"
                               style="width:50px" maxlength="9"
                               disabled="#{informeMarcacionSenoBean.modoconsulta}"
                               value="#{informeMarcacionSenoBean.informe.himnnumero}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumeroMarcacionSeno"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Medico que remite"
                              styleClass="labelTextOblig"/>
                <h:panelGroup/>
                <h:panelGroup>
                  <h:inputText id="itMedicoRemiteMarcacion" required="true"
                               onkeydown="return blockEnter(event);"
                               style="width:150px" maxlength="80"
                               disabled="#{informeMarcacionSenoBean.modoconsulta}"
                               value="#{informeMarcacionSenoBean.informe.himcmedicoremi}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itMedicoRemiteMarcacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridInformeMarcacionSeno2"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Informaci�n Clinica"
                              styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="itInformacionClinicaMarcacion" required="true"
                                   style="width:600px"
                                   disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                   value="#{informeMarcacionSenoBean.informe.himcdatosclire}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformacionClinicaMarcacion"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridInformeMarcacionSeno3"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Se Realizo Ecografia?"
                              styleClass="labelTextOblig"/>
                <h:outputText value="Dosis Entrada a Superficie"
                              styleClass="labelTextOblig"/>
                <h:panelGrid columns="2">
                  <h:selectOneRadio id="mnuEcografiaMarcacion" required="true"
                                    onkeydown="return blockEnter(event);"
                                    disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                    value="#{informeMarcacionSenoBean.informe.himcecografia}">
                    <f:selectItems value="#{informeMarcacionSenoBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuEcografiaMarcacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                <h:panelGroup>
                  <h:inputText id="itDosisMarcacion" required="true"
                               onkeydown="return blockEnter(event);"
                               style="width:50px" maxlength="1"
                               disabled="#{informeMarcacionSenoBean.modoconsulta}"
                               value="#{informeMarcacionSenoBean.informe.himndosisentra}"/>
                  <h:outputText value=" miliGreys (mGy)"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDosisMarcacion"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              
                <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelGridInformeMarcacionSeno4"
                           rowClasses="labelText,labelTextInfo">
                           
                 <h:outputText value="Informe"
                              styleClass="labelTextOblig"/>
                              
              
             <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{informeMarcacionSenoBean.mostrarBuscadorPlantilla}" immediate="true"
                 reRender="panelGridInformeMarcacionSenoTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="itInformeMarcacion"  immediate="true" 
                            onkeydown="return blockEnter(event);" 
                            binding="#{informeMarcacionSenoBean.itInforme}"
                            disabled="#{informeMarcacionSenoBean.modoconsulta}"
                            value= "#{informeMarcacionSenoBean.informe.himcinformamog}"
                            style="width:600px">
                            <f:validateLength minimum="2"/>
              </h:inputTextarea>
             
             <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformeMarcacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
            </h:panelGrid>             
                              
                            
                        </h:panelGrid>   
              <f:subview id="generarInformeMarcacionSeno"
                         rendered="#{informeMarcacionSenoBean.generoInforme}">
                <f:verbatim>
                  <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
                </f:verbatim>
              </f:subview>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelBotonesInformeMarcacionSeno" dir="RTL"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     disabled="#{informeMarcacionSenoBean.modoconsulta}"
                                     action="#{informeMarcacionSenoBean.generarMarcacionSeno}"/>
                                     <a4j:support event="onclick" status="statusButton"/>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionInformeMarcacionSenoMsg"
                               ajaxRendered="true">
                <t:messages id="msgInformationInformeMarcacionSenoMsg"
                            showSummary="true" errorClass="error"
                            globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
         <t:panelTab id="panelBuscadorMarcacion" label="Buscar Plantillas" rendered="#{informeMarcacionSenoBean.renderBuscador}">
      <a4j:region id="regionBuscadorMarcacion" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionBuscadorMarcacion">
          <f:facet name="start">
            <t:div id="chargingBuscadorMarcacion" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesMarcacion" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotones1Marcacion">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset" 
              action="#{informeMarcacionSenoBean.aceptarPlantilla}" 
                reRender="panelGridInformeMarcacionSenoTab">
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