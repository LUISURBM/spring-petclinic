<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesPatologicosTuberculinaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAntecedentesPatologicosTuberculina"
                     styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesPatologicosTuberculina" label="Antecedentes Patológicos Tuberculina">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAntecedentesPatologicosTuberculina" styleClass="tabContainer">
        <s:fieldset legend="Aplicación" id="fieldAntecedentes" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%">
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="VIH/SIDA" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosvih" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcvih}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcvih}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosvih" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Diabetes Mellitus" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosdm" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcdiabmelli}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcdiabmelli}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosdm" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Artritis  Reumatoide" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosar" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcartrireuma}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcartrireuma}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosar" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Esclerosis múltiple" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosem" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcesclmult}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcesclmult}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosem" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Cáncer" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosca" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapccancer}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapccancer}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosca" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Esclerosis  lateral amiotrófica" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosel" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcescllatamio}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcescllatamio}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosel" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Nefropatía" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosn" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcnefropa}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcnefropa}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosn" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Migraña" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosm" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcmigrana}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcmigrana}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosm" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Fibromialgia" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicosf" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcfibromi}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcfibromi}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicosf" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGrid>
            </h:panelGroup>
            
             <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Otra " styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesPatologicoso" immediate="true" value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapcotra}"
                                    valueChangeListener="#{AntecedentesPatologicosTuberculinaBean.setHapcotra}" required="true">
                    <f:selectItems value="#{AntecedentesPatologicosTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesPatologicosoo" event="onclick" action="#{AntecedentesPatologicosTuberculinaBean.changeOtraTuber}" reRender="panelInputOtraTuber">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesPatologicoso" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputOtraTuber">
                  <h:outputLabel value="¿Cual ?" styleClass="labelTextOblig"  rendered="#{AntecedentesPatologicosTuberculinaBean.renderCualPresenta}"/>
                  <h:inputText id="itotraTuber" required="true" rendered="#{AntecedentesPatologicosTuberculinaBean.renderCualPresenta}"
                               value="#{AntecedentesPatologicosTuberculinaBean.antecedpatol.hapccual}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itotraTuber" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            
          </h:panelGrid>
        </s:fieldset>
      
      </h:panelGrid>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardarAntecedentePatologicosTuberculina" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{AntecedentesPatologicosTuberculinaBean.aceptar}">
          <a4j:support event="onclick" status="statusButton" reRender="panelTabAntecedentesPatologicosTuberculina"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>