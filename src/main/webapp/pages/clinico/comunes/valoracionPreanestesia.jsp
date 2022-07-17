<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridValoracionPreanestesiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneValoracionPreanestesia"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabValoracionPreanestesia" label="Valoración Preanestesia"  >
    
           <s:fieldset legend="Cirugia" id="fieldCirugias"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelCirugias"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Intervención(es) Propuesta(s)"
                              styleClass="labelTextOblig"/>
                 <h:outputText/>
                 
                 
                 <h:inputText id = "itIntervencion" value = "#{valoracionPreanestesiaUsuarioBean.valoracion.hvpcinterpopue}" style="width:300px" maxlength="100"
                 required="true"/>
                 
                <a4j:outputPanel ajaxRendered="true">
                <t:message for="itIntervencion" styleClass="errorMessage"/>
              </a4j:outputPanel>
        
              </h:panelGrid>
             
        </s:fieldset>
     <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonesOrden"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Generar Valoración"
                                   styleClass="boton_fieldset"
                                   action="#{valoracionPreanestesiaUsuarioBean.generarValoracion}"/>
                                   <a4j:support event="onclick" status="statusButton"/>
              </h:panelGroup>
            </h:panelGrid>
</t:panelTab>

     
        
              <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesatributo1"
                               ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors1" showSummary="true"
                            errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
</t:panelTabbedPane>

    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>