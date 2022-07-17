<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRemisionilveTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneRemisionilve" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     selectedIndex="#{remisionIlveBean.selectedIndex}" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabRemisionilve" label="    ">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsRemisionilve"
                   styleClass="tabContainer">
            <s:fieldset legend="Paciente escoge voluntariamente al explicarle las opciones reproductivas" id="fieldAdopcion" styleClass="fieldset">
                    <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPacienteEscojeAdopcion"
                         rowClasses="labelText,labelTextInfo">
              <h:panelGroup>
                <h:outputText value="Paciente escoge voluntariamente:" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup id="desIveOpcionText">
                <h:outputText value="Observaciones" styleClass="labelTextOblig"
                              rendered="#{remisionIlveBean.renderInterVoluEmba}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneMenu id="mnuEscogeVoluntariamente" immediate="true" required="true"
                                   value="#{remisionIlveBean.remision.hricescogvolun}"
                                   valueChangeListener="#{remisionIlveBean.setHricescogvolun}">
                    <f:selectItems value="#{remisionIlveBean.lstOpcionesVoluntarias}"/>
                    <a4j:support id="supportmnuEscogeVoluntariamente"
                                 action="#{remisionIlveBean.changeOpcionVoluntaria}"
                                 reRender="panelGridRemisionilveTab" event="onchange">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                </a4j:region>
                <h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuEscogeVoluntariamente" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:panelGroup id="panelOutputVoluntaria">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                  <h:outputText value="Remita paciente a control prenatal con su asegurador y brinde información sobre recomendaciones y signos de alarma"
                                styleClass="labelTextOblig" rendered="#{remisionIlveBean.renderContinuarGesta}"/>
                  <h:outputText value="Brinde información sobre los centros legalmente constituidos de adopción"
                                styleClass="labelTextOblig" rendered="#{remisionIlveBean.renderAdopcion}"/>
                  <h:panelGroup>
                    <h:inputTextarea id="itIveOpcion" onkeydown="return blockEnter(event);" immediate="true"
                                     required="true" binding="#{remisionIlveBean.itDescripcionIVE}"
                                     value="#{remisionIlveBean.remision.hricdesinvoem}" style="width:500px;height:60px"
                                     rendered="#{remisionIlveBean.renderInterVoluEmba}"/>
                    <a4j:outputPanel ajaxRendered="true" rendered="#{remisionIlveBean.renderInterVoluEmba}">
                      <t:message for="itIveOpcion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="Teniendo en cuenta la enfermedad actual, la edad gestacional, antecedentes y examen físico brinde información sobre las diferentes técnicas de IVE y cuál es la indicada."
                                styleClass="labelTextOblig" rendered="#{remisionIlveBean.renderInterVoluEmba}"/>
                </h:panelGrid>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
			  </h:panelGrid>
                    </s:fieldset>
                   
                   
     
        
          
         <s:fieldset legend="Certificación IVE" id="fieldCertificacion" styleClass="fieldset" rendered = "#{remisionIlveBean.renderContinua}">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCertificacion"
                         rowClasses="labelText,labelTextInfo">
              <h:panelGroup>
                <h:outputText value="La usuaria escoge libremente la siguiente técnica:" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
              <h:outputText/>
              <h:panelGroup>
                <h:selectOneMenu id="mnuEscogeLibremente" immediate="true" required="true"
                                 value="#{remisionIlveBean.remision.hrictiporemis}">
                  <f:selectItems value="#{remisionIlveBean.lstTipoRemision}"/>
                </h:selectOneMenu>
              </h:panelGroup>
              <h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEscogeLibremente" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
              
              

              <h:panelGroup>
                <h:outputText value="Certificación Médica" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText/>
              <h:outputText/>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                <a4j:commandLink action="#{remisionIlveBean.mostrarBuscadorPlantilla}" immediate="true"
                                 reRender="panelGridRemisionilveTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputTextarea id="itCertificacion" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{remisionIlveBean.itDescripcion}"
                                 value="#{remisionIlveBean.remision.hriccertimedic}" style="width:500px;height:60px"/>
              </h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCertificacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
            </h:panelGrid>
          </s:fieldset>
          
          
             <s:fieldset legend="Causal" id="fieldAreaRemision" styleClass="fieldset" rendered = "#{remisionIlveBean.renderContinua}">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAreaRemisionMetodo"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Causal principal" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Causal secudaria" />
            <h:outputText/>
            <h:outputText value="Causal terciaria" />
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
            <h:selectOneMenu id="mnuCausal" immediate="true" 
            value="#{remisionIlveBean.remision.hriccausailve}"
            valueChangeListener="#{remisionIlveBean.setHriccausailve}"
            required="true"
                             onkeydown="return blockEnter(event);">
              <f:selectItems value="#{remisionIlveBean.lstTipoConducta}"/>
              <a4j:support id="supportCausal" event="onchange" immediate="true"
                        action="#{remisionIlveBean.changeLista2}"
                               reRender="fieldAreaRemision">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
              
            </h:selectOneMenu>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCausal" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <a4j:region renderRegionOnly="false">
            <h:selectOneMenu id="mnuCausal2" immediate="true" 
                            value="#{remisionIlveBean.remision.hriccausailve2}"
                            valueChangeListener="#{remisionIlveBean.setHriccausailve2}"
                             onkeydown="return blockEnter(event);">
              <f:selectItems value="#{remisionIlveBean.lstTipoConducta2}"/>
                <a4j:support id="supportCausal2" event="onchange" immediate="true"
                        action="#{remisionIlveBean.changeLista3}"
                               reRender="fieldAreaRemision">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
            </h:selectOneMenu>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCausal2" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:selectOneMenu id="mnuCausal3" immediate="true" 
                            value="#{remisionIlveBean.remision.hriccausailve3}"
                             onkeydown="return blockEnter(event);">
              <f:selectItems value="#{remisionIlveBean.lstTipoConducta3}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCausal3" styleClass="errorMessage"/>
            </a4j:outputPanel>
           
            
          </h:panelGrid>   
       
        </s:fieldset>
          
           <s:fieldset legend="Anticoncepción POSIVE" id="fieldAreaAnticoncepcion" styleClass="fieldset"  rendered = "#{remisionIlveBean.renderContinua}">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPlanifica"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Desea Planificar?" styleClass="labelTextOblig"/>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuPlanifica" immediate="true" required="true"
                                  value="#{remisionIlveBean.remision.hricdeseaplan}"
                                  onkeydown="return blockEnter(event);"
                                  valueChangeListener="#{remisionIlveBean.setHricdeseaplan}">
                  <f:selectItems value="#{remisionIlveBean.lstOpciones}"/>
                  <a4j:support id="supportPlanifica" event="onclick" action="#{remisionIlveBean.changePlanifica}"
                               reRender="panelAreaPosIlve,PanelNoAclara,panelNosuministra">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPlanifica" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          
              <h:panelGroup id="PanelNoAclara" >
               <h:outputText value="Aclaración" rendered="#{remisionIlveBean.renderAclaracion}"/>
               <h:inputTextarea id="PanelNoAclaraPlan" required="true"
                             value="#{remisionIlveBean.remision.hricobserplan}"
                             rendered="#{remisionIlveBean.renderAclaracion}"/>
              </h:panelGroup>
              
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAreaPosIlve"
                         rowClasses="labelText,labelTextInfo">
              <h:panelGroup>
                <h:outputText value="Método de anticoncepción elegido por la paciente" styleClass="labelTextOblig"
                              rendered="#{remisionIlveBean.renderPlanifica}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup>
                <h:outputText value="Cual" styleClass="labelTextOblig"
                              rendered="#{remisionIlveBean.renderOtroMetodo && remisionIlveBean.renderPlanifica}"/>
                <h:outputText value="Por qué?" styleClass="labelTextOblig"
                              rendered="#{remisionIlveBean.renderNingunMetodo && remisionIlveBean.renderPlanifica}"/>
                <h:outputText value=" Será suministrado por Profamilia?" styleClass="labelTextOblig"
                              rendered="#{!remisionIlveBean.renderNingunMetodo && !remisionIlveBean.renderOtroMetodo&& remisionIlveBean.renderPlanifica}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup>
                <h:selectOneMenu id="mnuMetodosPlanifica" immediate="true"
                                 value="#{remisionIlveBean.remision.hricmetodplani}"
                                 rendered="#{remisionIlveBean.renderPlanifica}"
                                 valueChangeListener="#{remisionIlveBean.setHricmetodplani}">
                  <f:selectItems value="#{remisionIlveBean.lstMetodo}"/>
                  <a4j:support id="supportmnuMetodosPlanificacion" event="onchange" immediate="true"
                               action="#{remisionIlveBean.ChangeMetodoPlanificacion}"
                               reRender="panelGridRemisionilveTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </h:panelGroup>
              <h:panelGroup>
                <a4j:outputPanel ajaxRendered="true" rendered="#{remisionIlveBean.renderPlanifica}">
                  <t:message for="mnuMetodosPlanifica" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelInputCualMetodo">
                <h:inputText id="InputOtroMetodo" maxlength="80" required="true"
                             value="#{remisionIlveBean.remision.hricotrometod}"
                             rendered="#{remisionIlveBean.renderOtroMetodo && remisionIlveBean.renderPlanifica}"/>
                <h:selectOneMenu id="mnuRechaza" required="true"
                                 rendered="#{remisionIlveBean.renderNingunMetodo && remisionIlveBean.renderPlanifica}"
                                 value="#{remisionIlveBean.remision.hricmotivrecha}">
                  <f:selectItems value="#{remisionIlveBean.lstRazones}"/>
                </h:selectOneMenu>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuSuministra" immediate="true" required="true"
                                    value="#{remisionIlveBean.remision.hricsumiprofa}"
                                    rendered="#{remisionIlveBean.renderPlanifica && !remisionIlveBean.renderOtroMetodo && !remisionIlveBean.renderNingunMetodo}"
                                    onkeydown="return blockEnter(event);"
                                    valueChangeListener="#{remisionIlveBean.setHricsumiprofa}">
                    <f:selectItems value="#{remisionIlveBean.lstOpciones}"/>
                    <a4j:support id="supportSuministra" event="onclick" action="#{remisionIlveBean.changeSuministra}"
                                 reRender="panelNosuministra">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
              </h:panelGroup>
              <h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{remisionIlveBean.renderOtroMetodo && remisionIlveBean.renderPlanifica}">
                  <t:message for="InputOtroMetodo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{remisionIlveBean.renderNingunMetodo  && remisionIlveBean.renderPlanifica}">
                  <t:message for="mnuRechaza" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{!remisionIlveBean.renderOtroMetodo && !remisionIlveBean.renderNingunMetodo && remisionIlveBean.renderPlanifica}">
                  <t:message for="mnuSuministra" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelNosuministra"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Por qué?" styleClass="labelTextOblig"
                            rendered="#{remisionIlveBean.renderNoPorque && remisionIlveBean.renderPlanifica && !remisionIlveBean.renderSuministra}"/>
              <h:outputText/>
              <h:panelGroup id="textoNoOtro">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                              rendered="#{remisionIlveBean.renderNootro && remisionIlveBean.renderPlanifica && !remisionIlveBean.renderSuministra}"/>
              </h:panelGroup>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="mnuNosuministra" required="true"
                                 rendered="#{remisionIlveBean.renderNoPorque && !remisionIlveBean.renderSuministra && remisionIlveBean.renderPlanifica}"
                                 value="#{remisionIlveBean.remision.hricsumiprofno}">
                  <f:selectItems value="#{remisionIlveBean.lstNosuministra}"/>
                  <a4j:support id="supportNoSuministra" event="onclick" action="#{remisionIlveBean.changeNootro}"
                               reRender="textoNoOtro,PanelNoOtro">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </a4j:region>
              <h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{!remisionIlveBean.renderSuministra && remisionIlveBean.renderPlanifica}">
                  <t:message for="mnuNosuministra" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="PanelNoOtro">
                <h:inputText id="InputNoOtro" maxlength="80" required="true"
                             value="#{remisionIlveBean.remision.hricsumiotro}"
                             rendered="#{remisionIlveBean.renderNootro && remisionIlveBean.renderPlanifica && !remisionIlveBean.renderSuministra}"/>
              </h:panelGroup>
              <h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{remisionIlveBean.renderNootro  && !remisionIlveBean.renderSuministra && remisionIlveBean.renderPlanifica}">
                  <t:message for="InputNoOtro" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText value="¿inicia método de planificación hoy?" styleClass="labelTextOblig"
                            rendered="#{remisionIlveBean.renderSiSuministraProfa && remisionIlveBean.renderPlanifica && remisionIlveBean.renderSuministra}"/>
              <h:outputText/>
              <h:outputText/>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuInicia" immediate="true" required="true"
                                  rendered="#{remisionIlveBean.renderSiSuministraProfa && remisionIlveBean.renderPlanifica && remisionIlveBean.renderSuministra}"
                                  value="#{remisionIlveBean.remision.hricinicimetod}"
                                  onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{remisionIlveBean.lstOpciones}"/>
                  <a4j:support id="supportInicia" event="onclick" action="#{remisionIlveBean.changeIniciaMetodo}">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true"
                               rendered="#{remisionIlveBean.renderSiSuministraProfa && remisionIlveBean.renderPlanifica && remisionIlveBean.renderSuministra}">
                <t:message for="mnuInicia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </s:fieldset>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesRemisionilve" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfRemisionilve" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscadorPlantillaIlve" label="Buscar Plantillas"
                rendered="#{remisionIlveBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantillaIlve" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantillaIlve">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantillaIlve" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantillaIlve" width="100%" columnClasses="columnaBotonesCentrados"
                     dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotonesPlantillaIlve">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset" action="#{remisionIlveBean.aceptarPlantilla}"
                               reRender="panelGridRemisionilveTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardarRemisionilve"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                         action="#{remisionIlveBean.guardarRemisionilve}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>