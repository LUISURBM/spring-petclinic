<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosEcografiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneDatosEcografia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosEcografia" label="Ecografia Fertilidad">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsDatosEcografia" styleClass="tabContainer">
        <s:fieldset legend="Datos Ecografia" id="fieldDatosEcografia" styleClass="fieldset_report">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosEcografia"
                       rowClasses=" ,labelTextInfo">
            <h:outputText value="Se tomo Ecografia"/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuEcografia" immediate="true" required="true"
                                value="#{datosEcografiaFertilidadBean.ecografia.hfectomaecog}"
                                onkeydown="return blockEnter(event);"
                                valueChangeListener="#{datosEcografiaFertilidadBean.setTomaEcografia}">
                <f:selectItems value="#{datosEcografiaFertilidadBean.lstOpciones}"/>
                <a4j:support id="supportmnuEcografia" event="onclick"
                             action="#{datosEcografiaFertilidadBean.changeEcografia}" 
                             reRender="panelOutputUtero,panelOutputAnexos,panelInputUtero,panelInputAnexos,panelOutputEndometrio,panelOutputRecuento,panelInputEndometrio,panelInputFoliculos,panelOutputObservaciones,panelObservaciones,panelFoliculosAntrales,panelOutputOvarioDerecho,panelInputFoliculos2,panelOutputOvarioIzquierdo,panelOutputResultado">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuEcografia" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id = "panelOutputUtero">
            <h:outputText value="Utero" styleClass="labelTextOblig" rendered="#{datosEcografiaFertilidadBean.renderEcografia}"/>
            </h:panelGroup>
            <h:outputText value=""/>
             <h:panelGroup id = "panelOutputAnexos">
            <h:outputText id = "textAnexos" value="Anexos" styleClass="labelTextOblig" rendered="#{datosEcografiaFertilidadBean.renderEcografia}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:panelGroup id = "panelInputUtero">
            <h:inputText id="itUtero" value="#{datosEcografiaFertilidadBean.ecografia.hfexutero}" 
                rendered="#{datosEcografiaFertilidadBean.renderEcografia}" required="true"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itUtero" styleClass="errorMessage"/>
            </a4j:outputPanel>
              <h:panelGroup id = "panelInputAnexos">
            <h:inputText id="itAnexos" value="#{datosEcografiaFertilidadBean.ecografia.hfecanexos}" 
            rendered="#{datosEcografiaFertilidadBean.renderEcografia}" required="true"
            maxlength="400"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itAnexos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id = "panelOutputEndometrio">
            <h:outputText value="Endometrio" styleClass="labelTextOblig" rendered="#{datosEcografiaFertilidadBean.renderEcografia}"/>
            </h:panelGroup>
           <h:outputText value=""/>
            <h:outputText value=""/>
           <h:outputText value=""/>
            
             <h:panelGroup id = "panelInputEndometrio">
            <h:inputText id="itEndometrio" value="#{datosEcografiaFertilidadBean.ecografia.hfecendometrio}"
            rendered="#{datosEcografiaFertilidadBean.renderEcografia}" required="true"
                         maxlength="400"/>
                         </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itEndometrio" styleClass="errorMessage"/>
            </a4j:outputPanel>
         
          </h:panelGrid>
          
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelFoliculosAntrales"
                       rowClasses="labelText,labelTextInfo"> 
  
            <h:panelGroup id = "panelOutputRecuento">
            <h:outputText value="Recuento de foliculos Antrales" rendered="#{datosEcografiaFertilidadBean.renderEcografia}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup>
                <h:outputText value="Multifolicular" styleClass="labelTextOblig"  rendered="#{datosEcografiaFertilidadBean.renderEcografia}"/>
                </h:panelGroup>
                <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup   rendered="#{datosEcografiaFertilidadBean.renderEcografia}">
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuMultifol" immediate="true" required="true"
                                value="#{datosEcografiaFertilidadBean.ecografia.hfecmultifol}"
                                onkeydown="return blockEnter(event);"
                                valueChangeListener="#{datosEcografiaFertilidadBean.setMultifolicular}">
                <f:selectItems value="#{datosEcografiaFertilidadBean.lstOpciones}"/>
                <a4j:support id="supportmnuMultifol" event="onclick"
                             action="#{datosEcografiaFertilidadBean.changeOvarios}" 
                             reRender="panelOutputRecuento,panelFoliculosAntrales,panelOutputOvarioDerecho,panelInputFoliculos2,panelOutputOvarioIzquierdo,panelOutputResultado">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            </h:panelGroup>
              <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id = "panelOutputOvarioDerecho">
            <h:outputText value="Ovario Derecho" styleClass="labelTextOblig" rendered="#{datosEcografiaFertilidadBean.renderOvarios}"/>
            </h:panelGroup>
            <h:outputText value=""/>
             <h:panelGroup id = "panelOutputOvarioIzquierdo">
            <h:outputText value="Ovario Izquierdo" styleClass="labelTextOblig"  rendered="#{datosEcografiaFertilidadBean.renderOvarios}"/>
            </h:panelGroup>
            <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
               <h:panelGroup id = "panelInputFoliculos"  rendered="#{datosEcografiaFertilidadBean.renderOvarios}">
             <h:selectOneMenu id="ovarioDerecho" value="#{datosEcografiaFertilidadBean.ecografia.hfecovarioder}"
                                required="true" immediate="true"
                                valueChangeListener="#{datosEcografiaFertilidadBean.setHfecovarioder}">
                <f:selectItems  value="#{datosEcografiaFertilidadBean.lstOvarioDerecho}"/>
                <a4j:support id="supportovarioDerecho" event="onchange" immediate="true" 
                               action="#{datosEcografiaFertilidadBean.calcularTotal}" reRender="panelOutputResultado">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
             <a4j:outputPanel ajaxRendered="true">
                 <t:message for="ovarioDerecho" styleClass="errorMessage"/>
             </a4j:outputPanel>
            </h:panelGroup>
            </a4j:region>
             <h:outputText value=""/>
             <a4j:region renderRegionOnly="false">
             <h:panelGroup id = "panelInputFoliculos2"  rendered="#{datosEcografiaFertilidadBean.renderOvarios}">
             <h:selectOneMenu id="ovarioIzquierdo" value="#{datosEcografiaFertilidadBean.ecografia.hfecovarioizq}" 
                              valueChangeListener="#{datosEcografiaFertilidadBean.setHfecovarioizq}" onkeydown="return blockEnter(event);"
                              immediate="true" required="true">
                <f:selectItems  value="#{datosEcografiaFertilidadBean.lstOvarioIzquierdo}"/> 
                <a4j:support id="supportovarioIzquierdo" event="onchange" immediate="true" 
                               action="#{datosEcografiaFertilidadBean.calcularTotal}" reRender="panelOutputResultado">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                
              </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
                 <t:message for="ovarioIzquierdo" styleClass="errorMessage"/>
             </a4j:outputPanel>

            </h:panelGroup>
            </a4j:region>
            <h:outputText value=""/>
            </h:panelGrid>
            
         <h:panelGrid style="text-align:left" columns="2" id="panelOutputResultado" border="0" cellpadding="0" rowClasses="labelText,labelTextInfo"
                       cellspacing="0" width="90%">
            <h:outputText value="#{datosEcografiaFertilidadBean.totalFoliculosAntrales}" styleClass="labelTextUnderLine2" rendered="#{datosEcografiaFertilidadBean.renderOvarios}"/>
         </h:panelGrid>

           <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelObservaciones"
                       rowClasses="labelText,labelTextInfo"> 
  
            <h:panelGroup id = "panelOutputObservaciones">
            <h:outputText value="Observaciones" styleClass="labelTextOblig" rendered="#{datosEcografiaFertilidadBean.renderEcografia}"/>
            </h:panelGroup>
             <h:outputText/>
             
               <h:inputTextarea id="itObservaciones" style="width:600px"
               value="#{datosEcografiaFertilidadBean.ecografia.hfecobservac}" 
            rendered="#{datosEcografiaFertilidadBean.renderEcografia}"/>
             <h:outputText/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itObservaciones" styleClass="errorMessage"/>
            </a4j:outputPanel>

         </h:panelGrid>
          
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonDatosEcografia"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{datosEcografiaFertilidadBean.guardar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>