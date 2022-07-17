<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
             id="panelGridAntecedentesColposcopiaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAntecedentesColposcopia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesColposcopia" label="Antecedentes Colposcopia">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAntecedentes"
                   styleClass="tabContainer">
            <s:fieldset legend="Datos Gestacionales 2" id="fieldAntecedentesEmbarazos" styleClass="fieldset">
            <a4j:region id="regionAntecedentes" renderRegionOnly="false">
              <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosAntecedentes" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Gestaciones" styleClass="labelTextOblig"/>
                <h:outputText value="Partos" styleClass="labelTextOblig"/>
                <h:outputText value="Abortos" styleClass="labelTextOblig"/>
                <h:outputText value="Cesareas" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:inputText id="itNumGesta" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesColposcopiaBean.itNumGesta}"
                                 required="false"
                                 title="Numero de Gestaciones" maxlength="2" style="width:30px"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnnumgesta}"
                                 valueChangeListener="#{antecedentesColposcopiaBean.setNumeroGestaciones}">
                      <a4j:support id="supportNumGesta" event="onchange" oncomplete="jsFunction()"
                                   action="#{antecedentesColposcopiaBean.changeNumeroGestaciones}"
                                   reRender="panelInputPartos,panelInputAbortos,panelInputCesareas,panelInputVivos,panelInputEctopicos,panelInputMuertos,panelInputMortinatos,panelCursor,panelInputParto,panelInputHijosNacidosVivos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumGesta" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                  <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelInputPartos">
                  <h:panelGroup>
                    <h:inputText id="itNumPartos" onkeydown="return blockEnter(event);"
                                 binding="#{antecedentesColposcopiaBean.itNumPartos}"
                                 required="false"
                                 title="Numero de Partos" immediate="true"
                                 disabled="#{antecedentesColposcopiaBean.esCeroGestaciones}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnnumparto}" 
                                 maxlength="2"
                                 style="width:30px">
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumPartos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                
                </a4j:region>
                <h:panelGroup id="panelInputAbortos">
                  <h:panelGroup>
                    <h:inputText id="itNumAbortos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesColposcopiaBean.itNumAbortos}"
                                 required="false"
                                 title="Numero de Abortos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesColposcopiaBean.esCeroGestaciones}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnnumaborto}">
                     
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumAbortos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputCesareas">
                  <h:panelGroup>
                    <h:inputText id="itNumcesareas" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesColposcopiaBean.itNumcesareas}"
                                 required="false"
                                 title="Numero de Cesareas" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesColposcopiaBean.esCeroGestaciones}"
                                 valueChangeListener="#{antecedentesColposcopiaBean.setNumeroCesarias}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnnumcesare}">
                                 
                                 <a4j:support id="supportNumCesareas" event="onchange"
                                   action="#{antecedentesColposcopiaBean.changeNumeroCesarias}"
                                   reRender="panelInputCesareas">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumcesareas" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                      
                      
                <h:outputText/>
                <h:outputText value="Hijos Vivos " styleClass="labelTextOblig"/>
                <h:outputText value="Ectopicos   " styleClass="labelTextOblig"
                              />
                <h:outputText value="Mortinatos  " styleClass="labelTextOblig"
                              />
                <h:outputText value="Molas       " styleClass="labelTextOblig"
                              />
                <h:outputText/>
               
                <h:panelGroup id="panelInputVivos">
                  <h:panelGroup>
                    <h:inputText id="itNumHijosVivos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesColposcopiaBean.itNumHijosVivos}"
                                 required="false"
                                 title="Numero de Hijos Vivos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesColposcopiaBean.esCeroGestaciones}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnnumvivo}"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumHijosVivos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputEctopicos"
                              >
                  <h:panelGroup>
                    <h:inputText id="itNumEctopicos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesColposcopiaBean.itNumEctopicos}" required="false"
                                 title="Numero de Ectopicos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesColposcopiaBean.esCeroGestaciones}"
                                 valueChangeListener="#{antecedentesColposcopiaBean.setNumeroEctopicos}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnectopico}">
                      <a4j:support id="supportNumEctopicos" event="onchange"
                                   action="#{antecedentesColposcopiaBean.changeNumeroEctopicos}"
                                   reRender="panelInputEctopicos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumEctopicos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputMortinatos"
                              >
                  <h:panelGroup>
                    <h:inputText id="itNumHijosMortinatos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesColposcopiaBean.itNumHijosMortinatos}" required="false"
                                 title="Numero de Mortinatos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesColposcopiaBean.esCeroGestaciones}"
                                 valueChangeListener="#{antecedentesColposcopiaBean.setNumeroMortinatos}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnmortina}">
                      <a4j:support id="supportNumMortinatos" event="onchange"
                                   action="#{antecedentesColposcopiaBean.changeNumeroMortinatos}"
                                   reRender="panelInputMortinatos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumHijosMortinatos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputMuertos" >
                  <h:panelGroup>
                    <h:inputText id="itNumHijosMuertos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesColposcopiaBean.itNumHijosMuertos}" required="false"
                                 title="Numero de Hijos Muertos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesColposcopiaBean.esCeroGestaciones}"
                                 valueChangeListener="#{antecedentesColposcopiaBean.setNumeroMolas}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnmolas}">
                      <a4j:support id="supportNumMolas" event="onchange"
                                   action="#{antecedentesColposcopiaBean.changeNumeroMolas}"
                                   reRender="panelInputMuertos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumHijosMuertos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                  <h:outputText/>
                
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
                  
                   
                   
        <s:fieldset legend="Antecedentes Colposcopia" id="fieldAntecedentes" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAntecedentesColposcopia"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="No Compañeros Sexuales" styleClass="labelTextOblig"/>
          
            <h:outputText/>
              <h:outputText value = "Edad Inicio de relaciones Sexuales " styleClass="labelTextOblig"/>
            <h:outputText/>
            
           
            <h:panelGroup>
              <h:inputText id="itNumSexuales" onkeydown="return blockEnter(event);" required="true"
                           title="Numero de Compañeros Sexuales"
                           value="#{antecedentesColposcopiaBean.antecedente.hacncompasexua}" maxlength="2"
                           style="width:30px"></h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itNumPartos" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
           <h:panelGroup>
                  <h:inputText id="itEdadPrimeraRelacion" onkeydown="return blockEnter(event);" maxlength="2"
                               value="#{antecedentesColposcopiaBean.antecedente.hacnedadrelac}"
                               valueChangeListener="#{antecedentesColposcopiaBean.setHacnedadrelac}"
                               style="width:30px">
                    <a4j:support id="supportEdadPrimeraRelacion" event="onchange"
                                 action="#{antecedentesColposcopiaBean.changeEdadPrimeraRelacion}"
                                 reRender="itEdadPrimeraRelacion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itEdadPrimeraRelacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
          </a4j:region>
           <h:outputText/>
           
            <h:outputText value="Diabetes" styleClass="labelTextOblig"/>
            
            <h:panelGroup id = "panelObservacionDiabetes">
              <h:outputText value="Observación Diabetes" styleClass="labelTextOblig"
              rendered="#{antecedentesColposcopiaBean.renderDiabetes}"/>
            </h:panelGroup>
            <h:outputText value="VIH" styleClass="labelTextOblig"/>
             <h:panelGroup id = "panelObservacionVIH">
             <h:outputText value="Observación VIH" styleClass="labelTextOblig" 
             rendered="#{antecedentesColposcopiaBean.renderVIH}"/>
             </h:panelGroup>
           
           
          
            <h:panelGroup>
              <h:selectOneRadio id="mnuDiabetes" required="true"
                                immediate="true"
                                value="#{antecedentesColposcopiaBean.antecedente.hacediabetes}"
                                valueChangeListener="#{antecedentesColposcopiaBean.setHacediabetes}"
                                styleClass="labelRadio">
                <f:selectItems value="#{antecedentesColposcopiaBean.lstOpciones}" />
                <a4j:support id="supportmnuDiabetes" event="onclick" immediate="true"
                            action="#{antecedentesColposcopiaBean.changeDiabetes}"
                             reRender="panelObservacionDiabetes,panelInputDiabetes">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuDiabetes" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
        
         <h:panelGroup id = "panelInputDiabetes">
              <h:inputText id="itObservacionDiabetes" onkeydown="return blockEnter(event);" required="true"
                            rendered="#{antecedentesColposcopiaBean.renderDiabetes}"
                           title="Observacion Diabetes"
                           value="#{antecedentesColposcopiaBean.antecedente.haccdiabetes}" maxlength="1000"
                           style="width:200px"></h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itObservacionDiabetes" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:selectOneRadio id="mnuVih" immediate="true"
                                value="#{antecedentesColposcopiaBean.antecedente.hacevih}"
                                valueChangeListener="#{antecedentesColposcopiaBean.setHacevih}"
                                styleClass="labelRadio">
                <f:selectItems value="#{antecedentesColposcopiaBean.lstOpciones}"/>
                  <a4j:support id="supportmnuVih" event="onclick" immediate="true"
                            action="#{antecedentesColposcopiaBean.changeVih}"
                             reRender="panelObservacionVIH,panelInputVih">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuVih" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
         
             
             <h:panelGroup id = "panelInputVih">
              <h:inputText id="itObservacionVih" onkeydown="return blockEnter(event);" required="true"
              rendered="#{antecedentesColposcopiaBean.renderVIH}"
                           title="Observacion VIH"
                           value="#{antecedentesColposcopiaBean.antecedente.haccvih}" maxlength="1000"
                           style="width:200px"></h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itObservacionVih" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
           
           
           
             <h:outputText value="ETS" styleClass="labelTextOblig"/>
            <h:panelGroup id = "panelObservacionETS">
           <h:outputText value="Observación ETS" styleClass="labelTextOblig"
           rendered="#{antecedentesColposcopiaBean.renderETS}"/>
           </h:panelGroup>
            <h:outputText value="Fuma " styleClass="labelTextOblig"/>
             <h:panelGroup id = "panelObservacionFuma">
           <h:outputText value="Observación Fuma" styleClass="labelTextOblig"
            rendered="#{antecedentesColposcopiaBean.renderFuma}"/>
           </h:panelGroup>
            
          
                 <h:panelGroup>
              <h:selectOneRadio id="mnuETS" immediate="true"
                                value="#{antecedentesColposcopiaBean.antecedente.haceets}"
                                valueChangeListener="#{antecedentesColposcopiaBean.setHaceets}"
                                styleClass="labelRadio">
                <f:selectItems value="#{antecedentesColposcopiaBean.lstOpciones}"/>
                 <a4j:support id="supportmnuETS" event="onclick" immediate="true"
                            action="#{antecedentesColposcopiaBean.changeETS}"
                             reRender="panelObservacionETS,panelInputEts">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                
                
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuETS" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
         
               <h:panelGroup id = "panelInputEts">
              <h:inputText id="itObservacionETS" onkeydown="return blockEnter(event);" required="true"
                           title="Observacion Ets"
                           rendered="#{antecedentesColposcopiaBean.renderETS}"
                           value="#{antecedentesColposcopiaBean.antecedente.haccets}" maxlength="1000"
                           style="width:200px"></h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itObservacionETS" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:selectOneRadio id="mnuFuma" immediate="true"
              value="#{antecedentesColposcopiaBean.antecedente.hacefuma}"
              valueChangeListener="#{antecedentesColposcopiaBean.setHacefuma}"
                                styleClass="labelRadio">
                <f:selectItems value="#{antecedentesColposcopiaBean.lstOpciones}"/>
                   <a4j:support id="supportmnuFuma" event="onclick" immediate="true"
                            action="#{antecedentesColposcopiaBean.changeFuma}"
                             reRender="panelObservacionFuma,panelInputFuma">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuFuma" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
              
                  
            <h:panelGroup id = "panelInputFuma">
              <h:inputText id="itObservacionFuma" onkeydown="return blockEnter(event);" required="true"
                           title="Observacion Fuma"
                           rendered="#{antecedentesColposcopiaBean.renderFuma}"
                           value="#{antecedentesColposcopiaBean.antecedente.haccfuma}" maxlength="1000"
                           style="width:200px"></h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itObservacionFuma" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
              
             <h:outputText value="Vacunación de VPH" styleClass="labelTextOblig"/>
            <h:panelGroup id = "otNumeroDosis">
            <h:outputText value="Numero de Dosis" rendered="#{antecedentesColposcopiaBean.renderNumeroDosis}"
                    styleClass="labelTextOblig"/>
            </h:panelGroup>
            
            <h:outputText/>
           <h:outputText/>
              
        
           <h:panelGroup>
             <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuVPH" value="#{antecedentesColposcopiaBean.antecedente.hacevacunvph}"
              immediate="true" valueChangeListener="#{antecedentesColposcopiaBean.setHacevacunvph}"
                                styleClass="labelRadio">
                <f:selectItems value="#{antecedentesColposcopiaBean.lstOpciones}"/>
                
                <a4j:support id="supportmnuVph" event="onclick"
                             
                             action="#{antecedentesColposcopiaBean.changeVph}"
                             reRender="panelNumeroDosis,otNumeroDosis">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                
              </h:selectOneRadio>
              
                  <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuVPH" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </a4j:region>
            </h:panelGroup>
            
            <h:panelGroup id = "panelNumeroDosis">
              <h:inputText id="itNumDosis" onkeydown="return blockEnter(event);" required="true"
              rendered="#{antecedentesColposcopiaBean.renderNumeroDosis}"
                           title="Numero de Dosis Vacuna VPH"
                           value="#{antecedentesColposcopiaBean.antecedente.hacnnumervph}" maxlength="2"
                           style="width:30px"></h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itNumDosis" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup> 
            
            <h:outputText/>
         <h:outputText/>
            
            <h:outputText value=" Tipificación VPH " />
            <h:panelGroup id = "panelTetxtGenotipificacion">
            <h:outputText value = "Genotipificación"   rendered="#{antecedentesColposcopiaBean.renderGenotipificacion}"/>
            </h:panelGroup>
            <h:outputText value = ""/>
            <h:outputText value = ""/>
            
            
       <h:panelGroup>
             <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="selectTipificacion" immediate="true"
                value = "#{antecedentesColposcopiaBean.antecedente.hacetipifvph}"
              valueChangeListener="#{antecedentesColposcopiaBean.setHacetipifvph}"
              > 
                     <f:selectItem itemValue = "" itemLabel = " Seleccione una Opción ..." />  
                     <f:selectItem itemValue = "SI" itemLabel = "SI" /> 
                     <f:selectItem itemValue = "NO" itemLabel = "NO"/>
                     <f:selectItem itemValue = "NS" itemLabel = "NO SABE"/>
                        <a4j:support id="supportmnuTipificacion" event="onclick" immediate="true"
                            action="#{antecedentesColposcopiaBean.changeTipificacion}"
                             reRender="panelTetxtGenotipificacion,panelInputGenotipificacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                 </h:selectOneMenu>    
             </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="selectTipificacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
               
             </h:panelGroup>
             
            <h:panelGroup  id = "panelInputGenotipificacion">
                 <h:inputText id="itGenotipificacion" onkeydown="return blockEnter(event);"
                                  required="false" maxlength="250"
                                 value="#{antecedentesColposcopiaBean.antecedente.haccgenotipifi}"
                                 rendered="#{antecedentesColposcopiaBean.renderGenotipificacion}" style="width:80px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itGenotipificacion" styleClass="errorMessage"/>
                    </a4j:outputPanel> 
            </h:panelGroup>
            
            
            <h:outputText value = ""/>
            <h:outputText value = ""/>
            
            
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosColposcopia2"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Antecedentes de procedimientos de cuello uterino (Conización, Crioterapia, Colposcopia, Cauterización, Radioterapia, Vaporización, Histerectomía, Biopsia, Tratamiento hormonal)"
                          styleClass="labelTextOblig"/>
            <h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuProcedimientosAnteriores" immediate="true"
                                value="#{antecedentesColposcopiaBean.antecedente.haccantecprevi}" 
                                valueChangeListener="#{antecedentesColposcopiaBean.setHaccantecprevi}"
                                styleClass="labelRadio">
                <f:selectItems value="#{antecedentesColposcopiaBean.lstOpciones}"/>
                  <a4j:support id="supportmnuProcedimientoAnteriores" event="onclick"
                             
                             action="#{antecedentesColposcopiaBean.changeProcedimietosCuello}"
                             reRender="panelTextResultado,panelInputResultado">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                
              </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuProcedimientosAnteriores" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id = "panelTextResultado">
            <h:outputText value="Resultado del procedimiento:" styleClass="labelTextOblig"
            rendered="#{antecedentesColposcopiaBean.renderResultado}"/>
            </h:panelGroup>
            <h:panelGroup id = "panelInputResultado">
              <h:inputTextarea id="textEstudiosPatologicos" required="true"
                              rendered="#{antecedentesColposcopiaBean.renderResultado}"
                               value="#{antecedentesColposcopiaBean.antecedente.haccresulproce}"
                               style="width:600px;height:50px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textEstudiosPatologicos" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        
        
        
        
            <s:fieldset legend="Ciclos" id="fieldAntecedentesCiclos" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
              id="panelDatosTieneCiclosColposcopia"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tipo de ciclo" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="radioTipoCiclo" immediate="true"
                                 required="false"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacetipciclo}"
                                 valueChangeListener="#{antecedentesColposcopiaBean.setTipoCiclo}">
                  <f:selectItems value="#{antecedentesColposcopiaBean.lstTipoCiclo}"/>
                  <a4j:support id="support" event="onchange" immediate="true" oncomplete="ciclosJs()"
                               action="#{antecedentesColposcopiaBean.changeTipo}"
                               reRender="panelAntecedentesCiclos">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="radioTipoCiclo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelAntecedentesCiclos" rowClasses="labelText,labelTextInfo">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosAntecedentesCiclos" rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="Frecuencia" rendered="#{antecedentesColposcopiaBean.tieneCiclo}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Duración" rendered="#{antecedentesColposcopiaBean.tieneCiclo}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itFrecuencia" onkeydown="return blockEnter(event);"
                                 required="false" maxlength="3"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnfreciclo}"
                                 rendered="#{antecedentesColposcopiaBean.tieneCiclo}" style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itFrecuencia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="-" rendered="#{antecedentesColposcopiaBean.cicloiregular}"/>
                  <h:panelGroup>
                    <h:inputText id="itFrecuenciaFinal" onkeydown="return blockEnter(event);"
                                 required="false" maxlength="3"
                                 rendered="#{antecedentesColposcopiaBean.cicloiregular && antecedentesColposcopiaBean.tieneCiclo}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacnfrefincicl}"
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itFrecuenciaFinal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itDuracion" onkeydown="return blockEnter(event);"
                                 required="false" maxlength="2"
                                 rendered="#{antecedentesColposcopiaBean.tieneCiclo}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacndurciclo}"
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDuracion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="-" rendered="#{antecedentesColposcopiaBean.cicloiregular}"/>
                  <h:panelGroup>
                    <h:inputText id="itDuracionFinal" onkeydown="return blockEnter(event);"
                                 required="false" maxlength="2"
                                 rendered="#{antecedentesColposcopiaBean.cicloiregular && antecedentesColposcopiaBean.tieneCiclo}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacndurfincicl}"
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDuracionFinal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                
                
                
           


                
                <h:panelGroup>
                  <h:outputText value="Edad Menarquia" styleClass="labelTextOblig"
                                rendered="#{antecedentesColposcopiaBean.tieneCiclo}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="F.U.R Normal"
                                rendered="#{antecedentesColposcopiaBean.tieneCiclo}"
                                title="Fecha Ultima Regla" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:inputText id="itEdadMenarquia" onkeydown="return blockEnter(event);" title="Edad Menarquia"
                               required="false" maxlength="2"
                               value="#{antecedentesColposcopiaBean.antecedente.hacnmenarquia}"
                               rendered="#{antecedentesColposcopiaBean.tieneCiclo}"
                               style="width:30px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itEdadMenarquia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="calendarUltimaRegla" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   rendered="#{antecedentesColposcopiaBean.tieneCiclo}"
                                   binding="#{antecedentesColposcopiaBean.itFechaRegla}"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{antecedentesColposcopiaBean.antecedente.hacdfur}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarUltimaRegla" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>



                


                
            
           
              <h:outputText value="Fecha Ultimo Parto o Aborto" styleClass="labelTextOblig" />
             
                 <h:panelGroup id="inputPanelParto">
              <h:outputText value="FUP ó Aborto" 
              title="Fecha Ultimo Parto" styleClass="labelTextOblig"
               rendered="#{antecedentesColposcopiaBean.mostrarFechaFUP}"/>
               </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
              
              
           
                
             
               <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuTemperatura" immediate="true" required="true"
                                value="#{antecedentesColposcopiaBean.antecedente.haccnoaplica}"
                                valueChangeListener="#{antecedentesColposcopiaBean.setHaccnoaplica}">
                <f:selectItems value="#{antecedentesColposcopiaBean.lstOpciones}"/>
                <a4j:support id="supportTemperatura" event="onclick" immediate="true"
                             action="#{antecedentesColposcopiaBean.changeFecha}"
                             reRender="panelInputParto,inputPanelParto">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTemperatura" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
            </a4j:region>
                    <h:panelGroup id="panelInputParto" >
                <t:inputCalendar id="calendarUltimoParto" title="Formato: dd/mm/yyyy"
                                 onkeydown="return blockEnter(event);" immediate="true"
                                 disabled="#{antecedentesColposcopiaBean.esCeroGestaciones}"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacdfup}"
                                 popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                 readonly="false" binding="#{antecedentesColposcopiaBean.itFechaParto}"
                                 maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true" rendered="#{antecedentesColposcopiaBean.mostrarFechaFUP}">
                  <f:validator validatorId="dateMenorIgualValidator"/>
                </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="calendarUltimoParto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
                <h:outputText/>
                 <h:outputText/>
                
                <h:outputText value="F.U.Citologia" title="Fecha Ultima Citologia" 
                styleClass="labelTextOblig"/>
                <h:panelGroup id = "panelResultadoCitologia">
                <h:outputText value = "Resultado"  styleClass="labelTextOblig" rendered="#{antecedentesColposcopiaBean.renderResultadoCitologia}"/>
                </h:panelGroup>
                <h:panelGroup id = "panelTextHallazgos">
                <h:outputText value="Cual?  "  rendered="#{antecedentesColposcopiaBean.renderOtroResultado}" styleClass="labelTextOblig" />
                </h:panelGroup>
                <h:outputText/>
                
                <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuUltimaCitologia" required="true" immediate="true"
                                   onkeydown="return blockEnter(event);"
                                   binding="#{antecedentesColposcopiaBean.mnuUltima}"
                                   value="#{antecedentesColposcopiaBean.antecedente.haccultcitolo}"
                                   valueChangeListener="#{antecedentesColposcopiaBean.setHaccultcitolo}">
                    <f:selectItems value="#{antecedentesColposcopiaBean.lstUltimaCitologia}"/>
                    <a4j:support id="supportUltimaCitologia" event="onchange"
                                 action="#{antecedentesColposcopiaBean.changeUltimaCitologia}"
                                 reRender="panelResultadoCitologia,panelMenuResul,panelTextHallazgos,panelInputHallazgos" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuUltimaCitologia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              
                 <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelMenuResul">
                  <h:selectOneMenu id="mnuResultadoGineco" required="true" immediate="true"
                                   onkeydown="return blockEnter(event);"
                                   rendered="#{antecedentesColposcopiaBean.renderResultadoCitologia}"
                                   binding="#{antecedentesColposcopiaBean.mnuResultado}"
                                   value="#{antecedentesColposcopiaBean.antecedente.haccresulcitol}"
                                   valueChangeListener="#{antecedentesColposcopiaBean.setHaccresulcitol}">
                    <f:selectItems value="#{antecedentesColposcopiaBean.lstResultado}"/>
                    <a4j:support id="supportResultadoUltimaCitologia" event="onchange"
                                 action="#{antecedentesColposcopiaBean.changeResultado}"
                                 reRender="panelTextHallazgos,panelInputHallazgos" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuResultadoGineco" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              
                 <h:panelGroup id="panelInputHallazgos">
                <h:inputText id="itOtrosHallazgos" maxlength="100" required="true"
                             onkeydown="return blockEnter(event);"
                             rendered="#{antecedentesColposcopiaBean.renderOtroResultado}"
                             value="#{antecedentesColposcopiaBean.antecedente.haccotroresul}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itOtrosHallazgos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>             
                <h:outputText/>
                
                
                 <h:outputText value="Método de Planificación Actual" styleClass="labelTextOblig"/>
              <h:panelGroup id="panelTextMetodo">
                <h:outputText value="Cual? " styleClass="labelTextOblig" rendered="#{antecedentesColposcopiaBean.mostrarMetodo}"/>
                <h:outputText value="Verifica uso correcto del método?" styleClass="labelTextOblig" rendered="#{antecedentesColposcopiaBean.mostrarPildoras}"/>
                <h:outputText value="Fecha de la última aplicación" styleClass="labelTextOblig"  rendered="#{antecedentesColposcopiaBean.mostrarInyectable}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextPildoras">
                 <h:outputText value="Aclaración Pildoras" styleClass="labelTextOblig" rendered="#{antecedentesColposcopiaBean.mostrarPildorasSi}"/>
                 <h:outputText rendered="#{!antecedentesColposcopiaBean.mostrarPildorasSi}"/>
              </h:panelGroup>
              <h:outputText/>
               
             
              
                <h:panelGroup>
                <h:selectOneMenu id="mnuMetodoPlanificacion" immediate="true"
                                 value="#{antecedentesColposcopiaBean.antecedente.haccmetodoplan}"
                                 onkeydown="return blockEnter(event);" required="true"
                                 valueChangeListener="#{antecedentesColposcopiaBean.setHaccmetodoplan}">
                  <f:selectItems value="#{antecedentesColposcopiaBean.lstMetodo}"/>
                  <a4j:support id="supporMetodoPlanificacion" event="onchange" immediate="true"
                               action="#{antecedentesColposcopiaBean.ChangeMetodo}"
                               reRender="panelInputMetodo,panelTextMetodo,panelTextPildoras,panelInputPildoras">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMetodoPlanificacion" styleClass="errorMessage" />
                </a4j:outputPanel>
              </h:panelGroup>

              <h:panelGroup id="panelInputMetodo">
                <h:inputText id="inputOtroMetodo" maxlength="50" onkeydown="return blockEnter(event);" 
                             required="true"
                             rendered="#{antecedentesColposcopiaBean.mostrarMetodo}"
                             value="#{antecedentesColposcopiaBean.antecedente.haccotrometodo}"/>
                             
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputOtroMetodo" styleClass="errorMessage" 
                        rendered="#{antecedentesColposcopiaBean.mostrarMetodo}"/>
                </a4j:outputPanel>

                <h:selectOneRadio id="mnuMetodoPildoras" immediate="true"
                                  onkeydown="return blockEnter(event);" required="true"
                                  rendered="#{antecedentesColposcopiaBean.mostrarPildoras}"
                                  valueChangeListener="#{antecedentesColposcopiaBean.setHaccpildouso}"
                                   value="#{antecedentesColposcopiaBean.antecedente.haccpildouso}">
                  <f:selectItems value="#{antecedentesColposcopiaBean.lstOpciones}"/>
                  <a4j:support id="supporMetodoPildoras" event="onchange" immediate="true"
                               action="#{antecedentesColposcopiaBean.ChangePildoras}"
                               reRender="panelTextPildoras,panelInputPildoras">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMetodoPildoras" styleClass="errorMessage" 
                             rendered="#{antecedentesColposcopiaBean.mostrarPildoras}"/>
                </a4j:outputPanel>
              
                <t:inputCalendar id="inputFechaMetodo" title="Formato: dd/mm/yyyy"
                                 onkeydown="return blockEnter(event);" immediate="true"                                 
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"                                 
                                 popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                 readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"  
                                 rendered="#{antecedentesColposcopiaBean.mostrarInyectable}"
                                 value="#{antecedentesColposcopiaBean.antecedente.hacdfeultiapl}"/>
                             
                              <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputFechaMetodo" styleClass="errorMessage" 
                            rendered="#{antecedentesColposcopiaBean.mostrarInyectable}"/>
                </a4j:outputPanel>
              </h:panelGroup>
              
              <h:panelGroup id="panelInputPildoras">
                <h:inputTextarea id="inputMetodoPildoras" onkeydown="return blockEnter(event);" 
                             required="true"
                             rendered="#{antecedentesColposcopiaBean.mostrarPildorasSi}"
                             value="#{antecedentesColposcopiaBean.antecedente.haccpildoobser}"/>
                             
                              <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputOtroMetodo" styleClass="errorMessage" 
                             rendered="#{antecedentesColposcopiaBean.mostrarPildorasSi}"/>
                </a4j:outputPanel>
                <h:outputText rendered="#{!antecedentesColposcopiaBean.mostrarPildorasSi}"/>
              </h:panelGroup>
              <h:outputText/>
            </h:panelGrid>
          <h:outputText value = ""/>
          <h:outputText value = ""/>
              
              
            </h:panelGrid>
        
          </s:fieldset>
          
          
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonModificarColposcopia" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             action="#{antecedentesColposcopiaBean.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid id="panelMensajesColposcopia">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>