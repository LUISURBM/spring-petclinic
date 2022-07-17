<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEstMascTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEstMasc" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabEstMasc" label="Cuestionario Esterilización Masculina">
      <s:fieldset legend="Preguntas Esterilización Masculina" id="fieldPreguntasEsterilizacion" styleClass="fieldset">
         <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="7">
            <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true" action="#{esterilizacionMasculinaBean.changeTodosSi}" reRender="tableContentTabsEstMasc"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true" action="#{esterilizacionMasculinaBean.changeTodosNo}" reRender="tableContentTabsEstMasc"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true" action="#{esterilizacionMasculinaBean.changeNinguno}" reRender="tableContentTabsEstMasc"/>
            <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
          </h:panelGrid>
        </a4j:region>
        <h:outputText value=" "/>
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEstMasc" 
              rowClasses="standardTable_Row3,standardTable_Row4">
              
         <t:div style="overflow:auto;  width:600px;height:30px;">  
          <h:outputText style="font-size:8.0pt;" value="1. Recibió usted información o asesoría sobre todos los métodos temporales de planificación familiar?"  />
          </t:div>
          <h:selectOneRadio id="hemcinformetod" value="#{esterilizacionMasculinaBean.esterilizacion.hemcinformetod}">
            <f:selectItems value="#{esterilizacionMasculinaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea value="#{esterilizacionMasculinaBean.esterilizacion.hemcaclarinfor}"   style="width:200px">
            <f:validateLength maximum="600"/>
          </h:inputTextarea>
          
           <t:div style="overflow:auto;  width:600px;height:30px;">  
          <h:outputText style="font-size:8.0pt;" value="2. Sabe usted que la vasectomía es un método definitivo de planificación familiar para el hombre?"  />
          </t:div>
          <h:selectOneRadio id="hemcvasecdefin" value="#{esterilizacionMasculinaBean.esterilizacion.hemcvasecdefin}">
            <f:selectItems value="#{esterilizacionMasculinaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea value="#{esterilizacionMasculinaBean.esterilizacion.hemcaclardefin}"  style="width:200px">
                <f:validateLength maximum="600"/>
          </h:inputTextarea>
          
          
          
           <t:div style="overflow:auto;  width:600px;height:30px;">  
          <h:outputText style="font-size:8.0pt;" value="3. Sabe usted que la vasectomía puede fallar, aun años después, entre 1 y 5 de cada 100 ?"  />
          </t:div>
          <h:selectOneRadio id="hemcvasecfalla" value="#{esterilizacionMasculinaBean.esterilizacion.hemcvasecfalnue}"
           >
            <f:selectItems value="#{esterilizacionMasculinaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea value="#{esterilizacionMasculinaBean.esterilizacion.hemcaclarfalnue}"  style="width:200px">
          <f:validateLength maximum="600"/>
          </h:inputTextarea>
          
          
          
           <t:div style="overflow:auto;  width:600px;height:30px;">  
          <h:outputText style="font-size:8.0pt;" value="4. Sabe usted que es necesario comprobar el éxito de la vasectomía, realizándose un espermograma de control a los tres meses de operado?"  />
          </t:div>
          <h:selectOneRadio id="hemcexitoesper" value="#{esterilizacionMasculinaBean.esterilizacion.hemcexitoesper}"
            >
            <f:selectItems value="#{esterilizacionMasculinaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea value="#{esterilizacionMasculinaBean.esterilizacion.hemcaclarexito}"  style="width:200px">
            <f:validateLength maximum="600"/>
          </h:inputTextarea>
          
          
           <t:div style="overflow:auto;  width:600px;height:30px;">  
          <h:outputText style="font-size:8.0pt;" value="5. Recibió información suficiente para suscribir el consentimiento informado para vasectomía?"  />
          </t:div>
          <h:selectOneRadio id="hemcinforsufic" value="#{esterilizacionMasculinaBean.esterilizacion.hemcinforsufic}"
            >
            <f:selectItems value="#{esterilizacionMasculinaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea value="#{esterilizacionMasculinaBean.esterilizacion.hemcaclarsufic}"   style="width:200px">
                <f:validateLength maximum="600"/>
          </h:inputTextarea>

          </h:panelGrid>
      
      </s:fieldset>
    </t:panelTab>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMensajesEsterMasc" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformationAndErrorsEsterMasc" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                    warnClass="advertencia"/>
        <t:htmlTag value="br"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
      id="panelBotonEsterMasc" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset" 
                    action="#{esterilizacionMasculinaBean.guardarCuestionario}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
       
      </h:panelGroup>
    </h:panelGrid>
</t:panelTabbedPane>
    
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>