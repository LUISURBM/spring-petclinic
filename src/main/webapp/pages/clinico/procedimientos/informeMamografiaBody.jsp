<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formInformeMamografia">
 <a4j:region id="regionInformeMamografia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionInformeMamografia">
      <f:facet name="start">
        <t:div id="chargingInformeMamografia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


 
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" 
               width="100%" id="panelGridInformeMamografiaTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneInformeMamografia"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabInformeMamografia" label="Informe Mamografia">
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridInformeContainer"
                       styleClass="tabContainer">
   <s:fieldset legend="Informe Mamografia" id="fieldInforme" 
                        styleClass="fieldset">
                        
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeMamografia" 
               rowClasses="labelText,labelTextInfo">
               
               <h:outputText value = "N�mero de Mamografia"  styleClass="labelTextOblig"/>
               <h:outputText value = "Medico que remite"  styleClass="labelTextOblig"/>
               <h:panelGroup>
                <h:inputText id = "itNumeroMamografia" required="true" style="width:50px" maxlength="9"
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himnnumero}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumeroMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
               </h:panelGroup>
                <h:panelGroup>
                <h:inputText id = "itMedicoRemite" required="true" style="width:150px" maxlength="80"
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcmedicoremi}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itMedicoRemite" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
  </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeMamografia2" 
               rowClasses="labelText,labelTextInfo">
                 <h:outputText value = "Datos Clinicos Relevantes"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itDatosClinicosRelevantes" required="true" style="width:600px"
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcdatosclire}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDatosClinicosRelevantes" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
                <h:outputText value = "Informe Mamografia"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itInformeMamografia" required="true" style="width:600px" 
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcinformamog}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformeMamografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
               <h:outputText value = "Dosis Entrada a Superficie"  styleClass="labelTextOblig"/>
                <h:panelGroup>
                <h:inputText id = "itDosis" required="true" style="width:50px" maxlength="1"
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himndosisentra}"/>
                <h:outputText value = " miliGreys (mGy)"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDosis" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
              <h:outputText value = "Informe como tal"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itInformeComoTal" required="true" style="width:600px" 
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcinformetal}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformeComoTal" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
         <h:outputText value = "Opini�n"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itOpinion" required="true" style="width:600px" 
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcopinion}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itOpinion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
               
        </h:panelGrid>
        
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeMamografia3" 
               rowClasses="labelText,labelTextInfo">
                 <h:outputText value = "Tipo Birads"  styleClass="labelTextOblig"/>
                 <h:outputText value = "Recomendaciones"  styleClass="labelTextOblig"/>
                       <h:panelGroup>
            <h:selectOneMenu id="menuTipoBirads" required="true" 
                            disabled="#{informeMamografiaBean.modoconsulta}"
                             value="#{informeMamografiaBean.informe.himctipobirads}">
              <f:selectItems value="#{informeMamografiaBean.lstTipoBirads}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuTipoBirads" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
                 
                  <h:panelGroup>
                <h:inputTextarea id = "itRecomendaciones" required="true" style="width:600px" 
                disabled="#{informeMamografiaBean.modoconsulta}"
                value= "#{informeMamografiaBean.informe.himcrecomendac}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itRecomendaciones" styleClass="errorMessage"/>
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
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>