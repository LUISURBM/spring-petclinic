<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMetodosAnticonceptivosTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenesDiagnostico"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenesDiagnostico" label="Metodos Anticonceptivos">
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsExamenesDiagnostico"
                     styleClass="tabContainer">
      <s:fieldset legend="Metodos" id="fieldSetExamenesDiagnosticos"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelExamenesDiagnosticos1"
                     rowClasses="labelText">
         <h:outputText value="¿Es el primer método que utiliza en su vida?:" 
                        styleClass="labelTextOblig"/>
        
        <h:outputText/>
        
          <h:panelGroup>
            <h:selectOneRadio id="radMetodo" required="true" onkeydown="return blockEnter(event);"
                            value="#{metodosAnticoncepcionBean.diagnostico.hedcprimmet}">
            <f:selectItem itemValue="S" itemLabel="Si"/>
            <f:selectItem itemValue="N" itemLabel="No"/>
          </h:selectOneRadio>
           <a4j:outputPanel ajaxRendered="true">
              <t:message for="radMetodo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          
            </h:panelGroup>
            <h:outputText />
            
             <h:outputText value="Metodo Paquete" styleClass="labelTextOblig" rendered="#{metodosAnticoncepcionBean.renderMetodoPaq}"/>
                        
             <h:outputText rendered="#{metodosAnticoncepcionBean.renderMetodoPaq}"/>
              <h:panelGroup rendered="#{metodosAnticoncepcionBean.renderMetodoPaq}">
            <h:selectOneMenu id="mnuMetodoPaq" required="true" onkeydown="return blockEnter(event);"
                            value="#{metodosAnticoncepcionBean.diagnostico.hednmetodopaq}" rendered="#{metodosAnticoncepcionBean.renderMetodoPaq}">
            <f:selectItems value="#{metodosAnticoncepcionBean.lstMetodoPaq}"/>
          </h:selectOneMenu>
           <a4j:outputPanel ajaxRendered="true" rendered="#{metodosAnticoncepcionBean.renderMetodoPaq}">
              <t:message for="mnuMetodoPaq" styleClass="errorMessage"/>
            </a4j:outputPanel>
          
            </h:panelGroup>
                        
             <h:outputText rendered="#{metodosAnticoncepcionBean.renderMetodoPaq}"/>         
             
                     
          <h:outputText value="Metodo que el Paciente desea usar:" 
                        styleClass="labelTextOblig"/>
          <h:outputText value="Contraindicaciones a Métodos Anticonceptivos -Especificar" 
                        styleClass="labelTextOblig"/>
           
            <h:panelGroup>
            <h:selectOneMenu id="mnuMetodo" required="true" onkeydown="return blockEnter(event);"
                            value="#{metodosAnticoncepcionBean.diagnostico.hedcmetodopaci}">
            <f:selectItems value="#{metodosAnticoncepcionBean.lstMetodo}"/>
          </h:selectOneMenu>
           <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMetodo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          
            </h:panelGroup>
             
             <h:panelGroup>
            <h:inputTextarea id="textContraindicaciones" required="true" onkeydown="return blockEnter(event);"
                             value="#{metodosAnticoncepcionBean.diagnostico.hedccontraindi}"
                             style="width:400px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textContraindicaciones" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
            <h:outputText value="Metodo sugerido:" 
                        styleClass="labelTextOblig"/>
              <h:outputText value="Dentro de los metodos anticonceptivos no contraindicados la paciente escoge libremente"
                       styleClass="labelTextOblig"/>
            
            <h:panelGroup>
            <h:selectOneMenu id="mnuMetodoSugerido" required="true" onkeydown="return blockEnter(event);"
                            value="#{metodosAnticoncepcionBean.diagnostico.hedcmetodosuge}">
            <f:selectItems value="#{metodosAnticoncepcionBean.lstMetodo}"/>
          </h:selectOneMenu>
             <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMetodoSugerido" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
             
          <h:panelGroup>
          <h:selectOneMenu id="mnuMetodoSolicita" required="true" onkeydown="return blockEnter(event);"
                            value="#{metodosAnticoncepcionBean.diagnostico.hedcmetodosoli}">
            <f:selectItems value="#{metodosAnticoncepcionBean.lstMetodo}"/>
          </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMetodoSolicita" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificarExamenesDiagnosticos"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar"   styleClass="boton_fieldset"
                             action="#{metodosAnticoncepcionBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>           
            </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid><h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributoExamenesDiagnosticos"
                         ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsExamenesDiagnosticos"
                      showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
 
</h:panelGrid>