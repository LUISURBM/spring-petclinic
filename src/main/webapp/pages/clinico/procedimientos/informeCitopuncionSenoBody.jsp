<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formInformeCitopuncion">
 <a4j:region id="regionInformeCitopuncion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionInformeCitopuncion">
      <f:facet name="start">
        <t:div id="chargingInformeCitopuncion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>

  

         <h:panelGrid id="verHistoriaClinica" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" >   
    
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentInfoLab"
         >
        
    
 
    </h:panelGrid>
</h:panelGrid>
 
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" 
               width="100%" id="panelGridInformeCitopuncionTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneInformeCitopuncion"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabInformeCitopuncion" label="Informe Citopunci�n">
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridInformeContainer"
                       styleClass="tabContainer">
   <s:fieldset legend="Informe Citopunci�n Seno" id="fieldInforme" 
                        styleClass="fieldset">
                        
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeCitopuncion" 
               rowClasses="labelText,labelTextInfo">
               
               <h:outputText value = "N�mero de Citopunci�n"  styleClass="labelTextOblig"/>
               <h:outputText value = "Medico que remite"  styleClass="labelTextOblig"/>
               <h:panelGroup>
                <h:inputText id = "itNumeroCitopuncion" required="true" style="width:50px" maxlength="9"
                disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                value= "#{informeCitopuncionSenoBean.informe.himnnumero}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumeroCitopuncion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
               </h:panelGroup>
                <h:panelGroup>
                <h:inputText id = "itMedicoRemite" required="true" style="width:150px" maxlength="80"
                disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                value= "#{informeCitopuncionSenoBean.informe.himcmedicoremi}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itMedicoRemite" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
  </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeCitopuncion2" 
               rowClasses="labelText,labelTextInfo">
                 <h:outputText value = "Informaci�n Clinica"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itDatosClinicosRelevantes" required="true" style="width:600px"
                disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                value= "#{informeCitopuncionSenoBean.informe.himcdatosclire}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDatosClinicosRelevantes" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
               <h:outputText value = "Transductor utilizado"  styleClass="labelTextOblig"/>
               
        <h:panelGroup>
            <h:selectOneMenu id="mnuInformeTransductor" required="true" disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                             value="#{informeCitopuncionSenoBean.informe.himctransducto}">
              <f:selectItems value="#{informeCitopuncionSenoBean.lstTransductor}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuInformeTransductor" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
               
           <h:outputText value = "Informe"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itInformeCitopuncion" required="true" style="width:600px" 
                disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                value= "#{informeCitopuncionSenoBean.informe.himcinformamog}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformeCitopuncion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
              
           
         <h:outputText value = "Conclusi�n"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itOpinion" required="true" style="width:600px" 
                disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                value= "#{informeCitopuncionSenoBean.informe.himcopinion}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itOpinion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
               
        </h:panelGrid>
        
   
   <f:subview id="generarInformeCitopuncion" rendered="#{informeCitopuncionSenoBean.generoInforme}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelBotonesInformeCitopuncion" dir="RTL"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Aceptar" styleClass="boton_fieldset"
                           disabled="#{informeCitopuncionSenoBean.modoconsulta}"
                           action="#{informeCitopuncionSenoBean.generarCitopuncion}"/>
      </h:panelGroup>
    </h:panelGrid>
  
  </s:fieldset>
  </h:panelGrid>
      <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionInformeCitopuncionMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationInformeCitopuncionMsg" showSummary="true"
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