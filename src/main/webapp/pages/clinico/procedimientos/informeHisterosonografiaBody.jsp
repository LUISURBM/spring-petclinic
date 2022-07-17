<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formInformeHisterosonografia">
 <a4j:region id="regionInformeHisterosonografia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionInformeHisterosonografia">
      <f:facet name="start">
        <t:div id="chargingInformeHisterosonografia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>

  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" 
               width="100%" id="panelGridInformeHisterosonografiaTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneInformeHisterosonografia"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabInformeHisterosonografia" label="Informe Histerosonografico">
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridInformeContainer"
                       styleClass="tabContainer">
   <s:fieldset legend="Informe Histerosonografico" id="fieldInforme" 
                        styleClass="fieldset">
                        
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInformeHisterosonografia2" 
               rowClasses="labelText,labelTextInfo">
                 <h:outputText value = "Indicaci�n del Examen "  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itIndicacionExamen" required="true" style="width:600px"
                disabled="#{informeHisterosonografiaBean.modoconsulta}"
                value= "#{informeHisterosonografiaBean.informe.himcdatosclire}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itIndicacionExamen" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
               <h:outputText value = "Transductor utilizado"  styleClass="labelTextOblig"/>
               
        <h:panelGroup>
            <h:selectOneMenu id="mnuInformeTransductor" required="true" disabled="#{informeHisterosonografiaBean.modoconsulta}"
                             value="#{informeHisterosonografiaBean.informe.himctransducto}">
              <f:selectItems value="#{informeHisterosonografiaBean.lstTransductor}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuInformeTransductor" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
               
           <h:outputText value = "Informe"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itInformeHisterosonografia" required="true" style="width:600px" 
                disabled="#{informeHisterosonografiaBean.modoconsulta}"
                value= "#{informeHisterosonografiaBean.informe.himcinformamog}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itInformeHisterosonografia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
              
           
         <h:outputText value = "Conclusi�n"  styleClass="labelTextOblig"/>
                 
            <h:panelGroup>
                <h:inputTextarea id = "itOpinion" required="true" style="width:600px" 
                disabled="#{informeHisterosonografiaBean.modoconsulta}"
                value= "#{informeHisterosonografiaBean.informe.himcopinion}"/>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itOpinion" styleClass="errorMessage"/>
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
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>