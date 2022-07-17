<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="infoReportePamecForm">
  <a4j:region id="bodyRegionReportePamec">
    <a4j:status for="bodyRegionReportePamec">
      <f:facet name="start">
        <t:div id="chargindReportePamec" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
     <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneReportePamec" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">

    
     <t:panelTab id="panelTabReportePamec" label="Reporte Pamec">
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Reporte Pamec" id="fieldSetInfoReportePamec" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionReportePamec"
                     rowClasses="labelText,labelTextInfo"> 
                     
                     
                     <h:outputText value = "A�o"  styleClass="labelTextOblig"/>
                     <h:outputText value = ""/>
                     
                     <h:outputText value = "Tema"  styleClass="labelTextOblig"/>
                     <h:outputText value = ""/>
                     
                     <h:inputText id = "itAnno" style="width:50px" maxlength="4"
                            value = "#{reportePamecBean.wanno}" required="true" />
                       <a4j:outputPanel ajaxRendered="true">
                           <t:message for="itAnno" styleClass="errorMessage"/>
                     </a4j:outputPanel>
                    
                    
                     <h:selectOneMenu id = "menuTema" value ="#{reportePamecBean.wcodigoTema}" required="true">
                       <f:selectItems value = "#{reportePamecBean.lstTema}"/>
                     </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                           <t:message for="menuTema" styleClass="errorMessage"/>
                     </a4j:outputPanel>
                     
                     <h:outputText value = "Clinica"  styleClass="labelTextOblig"/>
                     <h:outputText value = ""/>
                     
                   
                     
                     <h:outputText value = ""/>
                     <h:outputText value = ""/>
                       <h:selectOneMenu id = "menuClinica" value ="#{reportePamecBean.wcodclin}" required="true" >
                       <f:selectItems value = "#{reportePamecBean.lstClinica}"/>
                     </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                           <t:message for="menuClinica" styleClass="errorMessage"/>
                     </a4j:outputPanel>
                     
                     
                  
          
        </h:panelGrid>
           <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonReportePamec"
      columnClasses="panelGridBotones">
        <h:commandButton value="Generar Reporte" styleClass="boton"  
                           action="#{reportePamecBean.generarReporte}"/>
      </h:panelGrid>
      </s:fieldset>
      </a4j:region>
      
         
    </t:panelTab>
    </t:panelTabbedPane>
     <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesReportePamec" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfReportePamec" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      <f:subview id="generarReporte" rendered="#{reportePamecBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript"> 
            function enviar(){
                window.location="<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
            }
            </script>
          <a href="javascript:enviar()"><img src="../../../comun/imagenes/xls.png" height="100" width="100" alt="Descargue"><br/>Descargar Archivo</a>
        </f:verbatim>
      </f:subview>
  </a4j:region>
</a4j:form>