<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEncuestaViolenciaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEncuestaViolencia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabEncuestaViolencia" label="Encuesta Violencia">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEncuestaViolencia" styleClass="tabContainer">
     <s:fieldset legend="Sufre Violencia" id="fieldEnc" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEncustaViolencia" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Identificó algún tipo de violencia según el violentometro? " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuViolencia" immediate="true" required="true" value="#{encuestaViolenciaUsuarioBean.sufreViolencia}"
                                onkeydown="return blockEnter(event);"
                                valueChangeListener="#{encuestaViolenciaUsuarioBean.setSufreViolencia}">
                <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                <a4j:support id="supportmnuViolencia" event="onclick" oncomplete="cursorViolencia()"  action="#{encuestaViolenciaUsuarioBean.changeViolencia}"
                             reRender="tableContentViolencia,panelEncustaViolencia">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuViolencia" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Por favor realice la asesoría inicial de acuerdo al PROTOCOLOATENCIÓN INTEGRAL EN SALUD PARA VICTIMAS DE VIOLENCIA SEXUALPO-GS-CE-027 " style="color:blue;" rendered="#{encuestaViolenciaUsuarioBean.mostrarMensaje}" /> 
          </h:panelGrid>
        </s:fieldset>
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentViolencia" styleClass="tabContainer">
       <s:fieldset legend="Tipo de Violencia" id="fieldEncuestaViolencia" styleClass="fieldset" rendered="#{encuestaViolenciaUsuarioBean.mostrar}">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridTipoViolencia" rowClasses="labelText,labelTextInfo" >
            <h:outputText value="Fisica"/>
            <h:panelGroup id="panelOutputFisica">
              <h:outputText value="¿Por quién? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioFisica}"/>
            </h:panelGroup>
             <h:panelGroup id="panelOutputTiempoFisica">
              <h:outputText value="¿Tiempo de ocurrencia del evento? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioFisica}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkFisica" onkeydown="return blockEnter(event);" 
                                       value="#{encuestaViolenciaUsuarioBean.existeVioFisica}" 
                                       valueChangeListener="#{encuestaViolenciaUsuarioBean.setExisteVioFisica}"
                                       immediate="true">
                <a4j:support id="support3" event="onclick" action="#{encuestaViolenciaUsuarioBean.changeViolenciaFisica}" reRender="panelOutputFisica,panelInputFisica,panelInputTiempoFisica,panelOutputTiempoFisica">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:panelGroup id="panelInputFisica">
              <h:inputText id="mnuFisica" maxlength="20"  onkeydown="return blockEnter(event);" required="#{encuestaViolenciaUsuarioBean.existeVioFisica}" 
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hvicfisiquien}" rendered="#{encuestaViolenciaUsuarioBean.existeVioFisica}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuFisica" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            <h:panelGroup id="panelInputTiempoFisica">
              <h:selectOneMenu id="mnuTiempoFisica" immediate="true"  
                           required="#{encuestaViolenciaUsuarioBean.existeVioFisica}" 
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hvintiemfisi}" 
                           rendered="#{encuestaViolenciaUsuarioBean.existeVioFisica}"
                           valueChangeListener="#{encuestaViolenciaUsuarioBean.setHvintiemfisi}">
                     <f:selectItems value="#{encuestaViolenciaUsuarioBean.ltsTiempo}"/>  
                      <a4j:support id="supportMnuTiempoFisica" event="onchange" immediate="true" 
				action="#{encuestaViolenciaUsuarioBean.changeTiempoOcurrenciaEvento}" 
				reRender="panelMensajeInputTiempoFisica">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTiempoFisica" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            <h:panelGroup id="panelMensajeInputTiempoFisica">  
            <div>
            <h:outputText value="Recuerde diligenciar la ficha de notificación y activar código violeta y brindar la atención de acuerdo al PROTOCOLOATENCIÓN INTEGRAL EN SALUD PARA VICTIMAS DE VIOLENCIA SEXUALPO-GS-CE-027" style="color:blue; " rendered="#{encuestaViolenciaUsuarioBean.mostrarMensajeTipVioFisica}" />
            </div>
            </h:panelGroup> 
            
            
            <h:outputText value="Psicologica"/>
            <h:panelGroup id="panelOutputPsicologica">
              <h:outputText value="¿Por quién?" styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioPsicologica}"/>
            </h:panelGroup>
               <h:panelGroup id="panelOutputTiempoPsicologica">
              <h:outputText value="¿Tiempo de ocurrencia del evento? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioPsicologica}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkPsicologica" onkeydown="return blockEnter(event);" 
              value="#{encuestaViolenciaUsuarioBean.existeVioPsicologica}"
              valueChangeListener="#{encuestaViolenciaUsuarioBean.setExisteVioPsicologica}"
                                       immediate="true">
                <a4j:support id="support" event="onclick" immediate="true" action="#{encuestaViolenciaUsuarioBean.changeViolenciaPsicologica}" 
                reRender="panelOutputPsicologica,panelInputPsicologica,panelOutputTiempoPsicologica,panelInputTiempoPsicologica">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:panelGroup id="panelInputPsicologica">
              <h:inputText id="mnuPsicologica" maxlength="20" required="#{encuestaViolenciaUsuarioBean.existeVioPsicologica}" onkeydown="return blockEnter(event);"
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hvicpsicquien}" rendered="#{encuestaViolenciaUsuarioBean.existeVioPsicologica}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPsicologica" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
               <h:panelGroup id="panelInputTiempoPsicologica">
              <h:selectOneMenu id="mnuTiempoPsicologica" immediate="true"   
              required="#{encuestaViolenciaUsuarioBean.existeVioPsicologica}" 
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hvintiempsic}" 
                           rendered="#{encuestaViolenciaUsuarioBean.existeVioPsicologica}"
                           valueChangeListener="#{encuestaViolenciaUsuarioBean.setHvintiempsic}">
                     <f:selectItems value="#{encuestaViolenciaUsuarioBean.ltsTiempo}"/>   
                           <a4j:support id="supportMnuTiempoPsicologica" event="onchange" immediate="true" 
				action="#{encuestaViolenciaUsuarioBean.changeTiempoOcurrenciaEvento}" 
				reRender="panelMensajeInputTiempoPsicologica">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTiempoPsicologica" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelMensajeInputTiempoPsicologica">  
            <h:outputText value="Recuerde diligenciar la ficha de notificación y activar código violeta y brindar la atención de acuerdo al PROTOCOLOATENCIÓN INTEGRAL EN SALUD PARA VICTIMAS DE VIOLENCIA SEXUALPO-GS-CE-027" style="color:blue;" rendered="#{encuestaViolenciaUsuarioBean.mostrarMensajeTipVioPsicologica}"/>
            </h:panelGroup> 
            
            <h:outputText value="Sexual"/>
            <h:panelGroup id="panelOutputSexual">
              <h:outputText value="¿Por quién?" styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioSexual}"/>
            </h:panelGroup>
                  
               <h:panelGroup id="panelOutputTiempoSexual">
              <h:outputText value="¿Tiempo de ocurrencia del evento? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioSexual}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkSexual" value="#{encuestaViolenciaUsuarioBean.existeVioSexual}" valueChangeListener="#{encuestaViolenciaUsuarioBean.setExisteVioSexual}" onkeydown="return blockEnter(event);"
                                       immediate="true">
                <a4j:support id="supportSexual" event="onclick" immediate="true" action="#{encuestaViolenciaUsuarioBean.changeViolenciaSexual}" 
                reRender="panelOutputSexual,panelInputSexual,panelOutputTiempoSexual,panelInputTiempoSexual">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:panelGroup id="panelInputSexual">
              <h:inputText id="mnuSexual" maxlength="20" required="#{encuestaViolenciaUsuarioBean.existeVioSexual}" onkeydown="return blockEnter(event);"
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hvicsexuquien}" rendered="#{encuestaViolenciaUsuarioBean.existeVioSexual}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuSexual" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            
               <h:panelGroup id="panelInputTiempoSexual">
              <h:selectOneMenu id="mnuTiempoSexual"   immediate="true"
              required="#{encuestaViolenciaUsuarioBean.existeVioSexual}" 
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hvintiemsexu}" 
                           rendered="#{encuestaViolenciaUsuarioBean.existeVioSexual}"
                           valueChangeListener="#{encuestaViolenciaUsuarioBean.setHvintiemsexu}">
                     <f:selectItems value="#{encuestaViolenciaUsuarioBean.ltsTiempo}"/> 
                      <a4j:support id="supportMnuTiempoSexual" event="onchange" immediate="true" 
				action="#{encuestaViolenciaUsuarioBean.changeTiempoOcurrenciaEvento}" 
				reRender="panelMensajeInputTiempoSexual">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTiempoSexual" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
              <h:panelGroup id="panelMensajeInputTiempoSexual">  
            <h:outputText value="Recuerde diligenciar la ficha de notificación y activar código violeta y brindar la atención de acuerdo al PROTOCOLOATENCIÓN INTEGRAL EN SALUD PARA VICTIMAS DE VIOLENCIA SEXUALPO-GS-CE-027" style="color:blue;" rendered="#{encuestaViolenciaUsuarioBean.mostrarMensajeTipVioSexual}"/>
            </h:panelGroup> 
            
        <h:outputText value="Económica"/>
            <h:panelGroup id="panelOutputEconomica">
              <h:outputText value="¿Por quién? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioEconomica}"/>
            </h:panelGroup>
             <h:panelGroup id="panelOutputTiempoEconomica">
              <h:outputText value="¿Tiempo de ocurrencia del evento? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioEconomica}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkEconomica" onkeydown="return blockEnter(event);" 
			  value="#{encuestaViolenciaUsuarioBean.existeVioEconomica}" 
			  valueChangeListener="#{encuestaViolenciaUsuarioBean.setExisteVioEconomica}"
                                      immediate="true">
                <a4j:support id="support4" event="onclick" immediate="true" 
				action="#{encuestaViolenciaUsuarioBean.changeViolenciaEconomica}" 
				reRender="panelOutputEconomica,panelInputEconomica,panelOutputTiempoEconomica,panelInputTiempoEconomica">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:panelGroup id="panelInputEconomica">
              <h:inputText id="mnuEconomica" maxlength="20"  onkeydown="return blockEnter(event);" 
			   required="#{encuestaViolenciaUsuarioBean.existeVioEconomica}" 
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hviceconquien}" 
						   rendered="#{encuestaViolenciaUsuarioBean.existeVioEconomica}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuEconomica" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
		
                
        <h:panelGroup id="panelInputTiempoEconomica">
              <h:selectOneMenu id="mnuTiempoEconomica" immediate="true"  
              required="#{encuestaViolenciaUsuarioBean.existeVioEconomica}" 
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hvintiemecon}" 
                           rendered="#{encuestaViolenciaUsuarioBean.existeVioEconomica}"
                           valueChangeListener="#{encuestaViolenciaUsuarioBean.setHvintiemecon}">
                     <f:selectItems value="#{encuestaViolenciaUsuarioBean.ltsTiempo}"/>
                     <a4j:support id="supportMnuTiempoEconomica" event="onchange" immediate="true" 
				action="#{encuestaViolenciaUsuarioBean.changeTiempoOcurrenciaEvento}" 
				reRender="panelMensajeInputTiempoEconomica">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTiempoEconomica" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
	  <h:panelGroup id="panelMensajeInputTiempoEconomica">  
            <h:outputText value="Recuerde diligenciar la ficha de notificación y activar código violeta y brindar la atención de acuerdo al PROTOCOLOATENCIÓN INTEGRAL EN SALUD PARA VICTIMAS DE VIOLENCIA SEXUALPO-GS-CE-027" style="color:blue;" rendered="#{encuestaViolenciaUsuarioBean.mostrarMensajeTipVioEconomica}"/>
            </h:panelGroup> 		
			
	<h:outputText value="Coerción reproductiva "/>
            <h:panelGroup id="panelOutputCoercion">
              <h:outputText value="¿Por quién? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioCoercion}"/>
            </h:panelGroup>
             <h:panelGroup id="panelOutputTiempoCoercion">
              <h:outputText value="¿Tiempo de ocurrencia del evento? " styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.existeVioCoercion}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkCoercion" onkeydown="return blockEnter(event);" 
			  value="#{encuestaViolenciaUsuarioBean.existeVioCoercion}" 
			  valueChangeListener="#{encuestaViolenciaUsuarioBean.setExisteVioCoercion}"
                                       immediate="true">
                <a4j:support id="support5" event="onclick" immediate="true" 
				action="#{encuestaViolenciaUsuarioBean.changeViolenciaCoercion}" 
				reRender="panelOutputCoercion,panelInputCoercion,panelOutputTiempoCoercion,panelInputTiempoCoercion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:panelGroup id="panelInputCoercion">
              <h:inputText id="mnuCoercion" maxlength="20"  onkeydown="return blockEnter(event);" 
			   required="#{encuestaViolenciaUsuarioBean.existeVioCoercion}" 
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hviccoerquien}" 
						   rendered="#{encuestaViolenciaUsuarioBean.existeVioCoercion}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuCoercion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
                  <h:panelGroup id="panelInputTiempoCoercion">
              <h:selectOneMenu id="mnuTiempoCoercion" immediate="true"  
                           required="#{encuestaViolenciaUsuarioBean.existeVioCoercion}" 
                           value="#{encuestaViolenciaUsuarioBean.encuesta.hvintiemcoer}"
                           rendered="#{encuestaViolenciaUsuarioBean.existeVioCoercion}"
                           valueChangeListener="#{encuestaViolenciaUsuarioBean.setHvintiemcoer}">
                     <f:selectItems value="#{encuestaViolenciaUsuarioBean.ltsTiempo}"/>
                     <a4j:support id="supportMnuTiempoCoercion" event="onchange" immediate="true" 
				action="#{encuestaViolenciaUsuarioBean.changeTiempoOcurrenciaEvento}" 
				reRender="panelMensajeInputCoercion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTiempoCoercion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
              <h:panelGroup id="panelMensajeInputCoercion">  
            <h:outputText value="Recuerde diligenciar la ficha de notificación y activar código violeta y brindar la atención de acuerdo al PROTOCOLOATENCIÓN INTEGRAL EN SALUD PARA VICTIMAS DE VIOLENCIA SEXUALPO-GS-CE-027" style="color:blue;" rendered="#{encuestaViolenciaUsuarioBean.mostrarMensajeTipVioCoerciOnreproductiva}"/>
            </h:panelGroup> 
          </h:panelGrid>
        </s:fieldset>
       <s:fieldset legend="Factores de Riesgo" id="fieldEncuestaViolenciaAsesoria" styleClass="fieldset" rendered="#{encuestaViolenciaUsuarioBean.mostrar}">
                <h:outputText value = "Factores de Riesgo" style="color:red"/>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" 
                id="panelEncustaViolenciaFactoresdeRiesgo" rowClasses="labelText,labelTextInfo">
                    
                    <h:outputText value = "¿Alguna vez su pareja ha amenazado con hacerse daño y hacerle daño si usted lo deja?" styleClass="labelTextOblig"/>
                    <h:outputText value = ""/>
                    
                    
                      <h:selectOneRadio id="mnuAmenazado" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvicamenpare}"    
                      onkeydown="return blockEnter(event);">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuAmenazado" styleClass="errorMessage"/>
                        </a4j:outputPanel>
              
                 
                    
                    <h:outputText value = "¿Alguna vez usted ha pensado o intentado hacerse daño?" styleClass="labelTextOblig"/>
                    <h:outputText value = ""/>
                    
                    
                      <h:selectOneRadio id="mnuIntentado" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvicintedano}"     
                      onkeydown="return blockEnter(event);">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuIntentado" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                    
                    
                    <h:outputText value = "¿El agresor/a es parte de la familia inmediata?" styleClass="labelTextOblig"/>
                    <h:outputText value = ""/>
                    
                    
                      <h:selectOneRadio id="mnuAgresorFamilia" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvicagrefami}"     onkeydown="return blockEnter(event);">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuAgresorFamilia" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                    
                    
                    <h:outputText value = "¿El agresor/a convive en la misma casa?" styleClass="labelTextOblig"/>
                    <h:outputText value = ""/>
                    
              <h:selectOneRadio id="mnuAgresorConvive" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvicagrecasa}"     
                      onkeydown="return blockEnter(event);">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuAgresorConvive" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                    
                    
                    <h:outputText value = "¿La red familiar conoce la situación?" styleClass="labelTextOblig"/>
                    <h:outputText value = ""/>
                    
                    
              <h:selectOneRadio id="mnuAgresorRedConoce" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvicfamicono}"    
                      onkeydown="return blockEnter(event);">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuAgresorRedConoce" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                    
                     <h:outputText value = "¿DURANTE EL ULTIMO AÑO, ha sido humillada, menospreciada, insultada o amenazada por su pareja?" styleClass="labelTextOblig" rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}"/>
                    <h:outputText value = "" rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}"/>
                    
                    
                      <h:selectOneRadio id="mnuHumillado" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvichumeinam}"    
                      onkeydown="return blockEnter(event);"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}">
                                <t:message for="mnuHumillado" styleClass="errorMessage"/>
                        </a4j:outputPanel>
              
               <h:outputText value = "¿DURANTE EL ÚLTIMO AÑO, fue golpeada, bofeteada, pateada, o lastimada físicamente de otra manera?" styleClass="labelTextOblig"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}"/>
                    <h:outputText value = ""  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}"/>
                    
                    
                      <h:selectOneRadio id="mnuGolpeada" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvicgobopalaul}"    
                      onkeydown="return blockEnter(event);"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}">
                                <t:message for="mnuGolpeada" styleClass="errorMessage"/>
                        </a4j:outputPanel>
              
               <h:outputText value = "¿DESDE QUE ESTÁ EN GESTACIÓN, ha sido golpeada, bofeteada, pateada, o lastimada físicamente de alguna manera?" styleClass="labelTextOblig"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}"/>
                    <h:outputText value = ""  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}"/>
                    
                    
                      <h:selectOneRadio id="mnuGestacion" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvicgobopalage}"    
                      onkeydown="return blockEnter(event);"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}">
                                <t:message for="mnuGestacion" styleClass="errorMessage"/>
                        </a4j:outputPanel>
              
               <h:outputText value = "¿DURANTE EL ÚLTIMO AÑO, fue forzada a tener relaciones sexuales?" styleClass="labelTextOblig"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}"/>
                    <h:outputText value = ""  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}"/>
                    
                    
                      <h:selectOneRadio id="mnuforzada" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvicforrelsex}"    
                      onkeydown="return blockEnter(event);"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true"  rendered="#{encuestaViolenciaUsuarioBean.renderPrenatal}">
                                <t:message for="mnuforzada" styleClass="errorMessage"/>
                        </a4j:outputPanel>
              
              
                </h:panelGrid>
              </s:fieldset>
              
               <s:fieldset legend="Remision" id="fieldEncuestaViolenciaAsesoriaRemision" styleClass="fieldset" rendered="#{encuestaViolenciaUsuarioBean.mostrar}">
                 <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEncustaViolenciaRiesgo2" rowClasses="labelText,labelTextInfo">
                  
                 
                    <h:outputText value="Se realiza remision Interna"   styleClass="labelTextOblig"/>
                    <h:panelGroup id = "panelGroupTextRemisionInterna">
                    <h:outputText value = "Tipo de Remision Interna"
                    rendered="#{encuestaViolenciaUsuarioBean.renderRemisionInterna}"
                    styleClass="labelTextOblig"/>
                    </h:panelGroup>
                    <h:outputText/>
                    
                    <h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                       <h:selectOneRadio id="mnuRemisionInterna" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvictienrein}" 
                      valueChangeListener="#{encuestaViolenciaUsuarioBean.setHvictienrein}">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                     <a4j:support id="supportmnuRemisionInterna" event="onchange" immediate="true"
                                    action="#{encuestaViolenciaUsuarioBean.changeRemisionInterna}" 
                                    reRender="panelGroupTextRemisionInterna,panelInputRemitidoInterno">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuRemisionInterna" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                        </a4j:region>
                    </h:panelGroup>
                    
                    <h:panelGroup id="panelInputRemitidoInterno">
                    <h:selectOneMenu id="mnuTipoRemisionInterna"  rendered="#{encuestaViolenciaUsuarioBean.renderRemisionInterna}"
                                    onkeydown="return blockEnter(event);"
                                     value="#{encuestaViolenciaUsuarioBean.encuesta.hvicremiinte}" >
                      <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstRemisionInterna}"/>
                    </h:selectOneMenu>
                    
                    </h:panelGroup>
                    <h:outputText/>
                    
                    
                    
                    <h:outputText value="Se realiza remision Externa"   styleClass="labelTextOblig"/>
                    <h:panelGroup id= "panelGroupTextRemisionExterna">
                    <h:outputText value = "Tipo de Remision Externa" styleClass="labelTextOblig" 
                    rendered="#{encuestaViolenciaUsuarioBean.renderRemisionExterna}"/>
                    </h:panelGroup>
                     <h:panelGroup id="panelOutputCual">
                    <h:outputText value=" Cual" rendered="#{encuestaViolenciaUsuarioBean.mostrarCual}" styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  
                    
                   <h:panelGroup id="panelRemision">
                    <a4j:region renderRegionOnly="false">
                       <h:selectOneRadio id="mnuRemisionExterna" immediate="true" required="true"
                      value="#{encuestaViolenciaUsuarioBean.encuesta.hvictienreex}"     
                      valueChangeListener="#{encuestaViolenciaUsuarioBean.setHvictienreex}"
                      onkeydown="return blockEnter(event);">
                    <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstOpcionesViolencia}"/>
                      <a4j:support id="supportmnuRemisionExterna" event="onchange" immediate="true"
                                    action="#{encuestaViolenciaUsuarioBean.changeRemisionExterna}" 
                                    reRender="panelGroupTextRemisionExterna,panelInputRemitidoExterno,panelInPutCual,panelOutputCual">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                        <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuRemisionExterna" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                         </a4j:region>
                    </h:panelGroup>
                    
                    <h:panelGroup id="panelInputRemitidoExterno">
                     <a4j:region renderRegionOnly="false">
                    <h:selectOneMenu id="mnuTipoRemisionExterno"  
                                    onkeydown="return blockEnter(event);"
                                    binding="#{encuestaViolenciaUsuarioBean.mnuTipoRemisionExterno}"
                                    rendered="#{encuestaViolenciaUsuarioBean.renderRemisionExterna}"
                                     value="#{encuestaViolenciaUsuarioBean.encuesta.hvicremiexte}" 
                                     valueChangeListener="#{encuestaViolenciaUsuarioBean.setHvicremiexte}">
                      <f:selectItems value="#{encuestaViolenciaUsuarioBean.lstRemisionExterna}"/>
                       <a4j:support id="supportmnuRemisionExterno" event="onchange"
                                    action="#{encuestaViolenciaUsuarioBean.changeOtro}" 
                                    reRender="panelInPutCual,panelOutputCual">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    </a4j:region>
                    </h:panelGroup>
                    
                    
                      <h:panelGroup id="panelInPutCual">
                    <h:inputText id="itCual" value="#{encuestaViolenciaUsuarioBean.encuesta.hvilcualremisi}" 
                    maxlength="100" 
                    rendered="#{encuestaViolenciaUsuarioBean.mostrarCual}"/>
                  </h:panelGroup>
 
                    
                
               
                </h:panelGrid>
                
                     <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEncustaViolenciaRiesgoObservaciones" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Observaciones"/>
                  <h:outputText/>
                  <h:inputTextarea id="textObservaciones" value="#{encuestaViolenciaUsuarioBean.encuesta.hvitobserva}" style="width:600px" />
                </h:panelGrid>
              </s:fieldset>
        </h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
          </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{encuestaViolenciaUsuarioBean.guardarEncuesta}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <f:verbatim>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
    </script>
    </f:verbatim>
</h:panelGrid>
