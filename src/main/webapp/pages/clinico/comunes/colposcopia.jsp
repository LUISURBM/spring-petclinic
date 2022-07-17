<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridColposcopiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneColposcopia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabColposcopia" label="Colposcopia">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridColposcopia">
        <s:fieldset legend="Evaluacion General " id="fieldSetColposcopia" styleClass="fieldset">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosColposcopia"
                       rowClasses="labelText,labelTextInfo">
                       
                  <h:outputText value = "Evaluación General"  styleClass="labelTextOblig"/>     
                  <h:outputText value = ""/>
                  <h:panelGroup id = "panelTextVisibilidad">
                  <h:outputText value = "Visibilidad de union escamocolumnar " styleClass="labelTextOblig"
                  rendered="#{!colposcopiaBean.renderAdecuada}"/>
                  <h:outputText value = "Visibilidad de union escamocolumnar " rendered="#{colposcopiaBean.renderAdecuada}"/>
                  </h:panelGroup>
                  <h:outputText value = ""/>
                  <h:panelGroup id = "panelTextZona">
                  <h:outputText value = "Zona de transformacion tipo" styleClass="labelTextOblig" rendered="#{!colposcopiaBean.renderAdecuada}"/>
                  <h:outputText value = "Zona de transformacion tipo" rendered="#{colposcopiaBean.renderAdecuada}"/>
                  </h:panelGroup>
                  <h:outputText value = ""/>
                  <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuEvaluacion" immediate="true" required="false"
                            value="#{colposcopiaBean.coloposcopia.hclcevalugener}"
                            valueChangeListener="#{colposcopiaBean.setHclcevalugener}"
                                styleClass="labelRadio">
                <f:selectItems value="#{colposcopiaBean.lstTipoEvaluacion}"/>
                <a4j:support id="supportMnuEvaluacion" event="onclick" immediate="true"
                                 action="#{colposcopiaBean.changeEvaluacionGeneral}"
                                 reRender="panelDatosColposcopia">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                
                
              </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuEvaluacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:selectOneMenu id="mnuVisibilidadUnion" 
                            required="#{!colposcopiaBean.renderAdecuada}"
                           value="#{colposcopiaBean.coloposcopia.hclcvisioescam}"
                           onkeydown="return blockEnter(event);">
            <f:selectItems value="#{colposcopiaBean.lstVisibilidadEscamo}"/>
          </h:selectOneMenu>
           <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuVisibilidadUnion" styleClass="errorMessage"/>
           </a4j:outputPanel>
                <h:selectOneMenu id="mnuZonaTransformacion" 
                            required="#{!colposcopiaBean.renderAdecuada}"
                           value="#{colposcopiaBean.coloposcopia.hclczonatrans}"
                           onkeydown="return blockEnter(event);">
            <f:selectItems value="#{colposcopiaBean.lstTipoZonaTranformacion}"/>
          </h:selectOneMenu>
           <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuZonaTransformacion" styleClass="errorMessage"/>
           </a4j:outputPanel>
              
               <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelEvaluacionInadecuasa" rowClasses="standardTable_Row7,standardTable_Row7"
                         style="border-color:#3f3e23;" rendered="#{colposcopiaBean.renderAdecuada}">
              <h:outputText value="Evaluacion Inadecuada" styleClass="labelTextOblig"/>
              <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                      id="mnuEvaluacionInadecuada"
                                      value="#{colposcopiaBean.lstEvaluacionInadecuadaSelect}"
                                      valueChangeListener="#{colposcopiaBean.setLstEvaluacionInadecuadaSelect}"
                                      layout="pageDirection">
                  <f:selectItems value="#{colposcopiaBean.lstEvaluacionInadecuada}"/>
                  
                     <a4j:support id="supportmnuEvaluacionInadecuada" event="onclick" immediate="true"
                                 action="#{colposcopiaBean.changeOtroEvaluacion}"
                                 reRender="panelEvaluacionInadecuasa">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  
                </h:selectManyCheckbox>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEvaluacionInadecuada" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              
               <h:panelGroup id="panelCualEvaluacionInadecuada" rendered="true">
                <h:outputText value="Cúal? " styleClass="labelTextOblig"
                              rendered="#{colposcopiaBean.renderOtroAdecuada}" />
                <h:inputTextarea id="itCualInadecuado" style="width:300px" required="true"
                             rendered="#{colposcopiaBean.renderOtroAdecuada}"
                             value="#{colposcopiaBean.coloposcopia.hclcinadecual}">
                    <f:validateLength maximum="800"/>             
                </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualInadecuado" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              
              
            </h:panelGrid>
                       
                       
                       
                       
          </h:panelGrid>
          
          
           <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
         
                id="panelDatos"
                       rowClasses="labelText,labelTextInfo">
            
            
            <h:outputText value = "Tipo de Hallazgo"  styleClass="labelTextOblig"/>
            <h:outputText value = ""/>
            
            
             <h:selectOneRadio id="mnuTipoHallazgo" required="true" immediate="true"
             value="#{colposcopiaBean.coloposcopia.hclctipohalla}"
             valueChangeListener="#{colposcopiaBean.setHclctipohalla}"
                                styleClass="labelRadio">
                <f:selectItems value="#{colposcopiaBean.ltsTipoHallazgo}"/>
                   <a4j:support id="supportMnuTipoHallazgo" event="onclick" immediate="true"
                                 action="#{colposcopiaBean.changeTipoHallazgos}"
                                 reRender="panelGridColposcopiaTab">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                
                
              </h:selectOneRadio>
            
              <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTipoHallazgo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                       
             </h:panelGrid>
        </s:fieldset>
        
        
          <s:fieldset legend="Hallazgos Normal " id="fieldSetColposcopiaHallazgosNormal" 
            rendered="#{colposcopiaBean.renderNormal}"
          styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" 
          
            id="panelDatosColposcopiaHallazgosNormal"
                       rowClasses="labelText,labelTextInfo">
                       
                      
                
                     
                       
                     
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelHallazgoNormal" rowClasses="standardTable_Row7,standardTable_Row7"
                         style="border-color:#3f3e23;">
             <h:outputText value = "Hallazgo colposcópico normal"/> 
              <h:panelGroup>
                <h:selectManyCheckbox  style="border-style:none;" immediate="true"
                                      id="mnuHallazgoNormal"
                                      value="#{colposcopiaBean.lstHallazgosNormalSelect}" 
                                      layout="pageDirection">
                  <f:selectItems value="#{colposcopiaBean.lstHallazgosNormal}"/>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHallazgoNormal" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>      
            </h:panelGrid>  
            
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelHallazgoVarios" rowClasses="standardTable_Row8,standardTable_Row8"
                         style="border-color:#3f3e23;">
             <h:outputText value = "Hallazgos varios"/>  
              <h:panelGroup>
                <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                      id="mnuHallazgoVarios"
                                      value="#{colposcopiaBean.lstHallazgosVariosSelect}"
                                      valueChangeListener="#{colposcopiaBean.setLstHallazgosVariosSelect}"
                                      layout="pageDirection">
                  <f:selectItems value="#{colposcopiaBean.lstHallazgosVarios}"/>
                   <a4j:support id="supportmnuHallazgosVarios" event="onclick" immediate="true"
                                 action="#{colposcopiaBean.changeOtroVarios}"
                                 reRender="panelCualHallazgosVarios">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHallazgoVarios" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>    
                <h:panelGroup id="panelCualHallazgosVarios" rendered="true">
                <h:outputText value="Cúal? "
                            styleClass="labelTextOblig"
                              rendered="#{colposcopiaBean.renderOtosVarios}"/>
                <h:inputText id="itCualHallazgosVarios" style="width:300px" maxlength="100" required="true"
                             rendered="#{colposcopiaBean.renderOtosVarios}" 
                             value="#{colposcopiaBean.coloposcopia.hclchallacual}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualHallazgosVarios" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>  
              
            </h:panelGrid>  
                   
              
                       
                       </h:panelGrid>
                </s:fieldset>  
           <s:fieldset legend="Hallazgos colposcopicos anormales " id="fieldSetColposcopiaHallazgosAnormal"
             rendered="#{!colposcopiaBean.renderNormal}"
           styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelDatosColposcopiaHallazgosAnormal"
                       rowClasses="labelText,labelTextInfo">
                       
                       
            <h:panelGroup>  
            <a4j:region renderRegionOnly="false">
            <h:selectOneMenu id="mnuHallazgosAnormales" immediate="true" required="false"
                value="#{colposcopiaBean.coloposcopia.hclcgradohalla}"
                valueChangeListener="#{colposcopiaBean.setHclcgradohalla}"
                                styleClass="labelRadio">
                <f:selectItems value="#{colposcopiaBean.lstGradoHallazgos}"/>
                 <a4j:support id="supportHallazgosAnormales" event="onchange" immediate="true"
                                 action="#{colposcopiaBean.changeGradoHallazgos}"
                                 reRender="fieldSetColposcopiaHallazgosAnormal">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                
                
              </h:selectOneMenu>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuHallazgosAnormales" styleClass="errorMessage"/>
              </a4j:outputPanel>
               </h:panelGroup>
                     
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelHallazgoGrado1" rowClasses="standardTable_Row7,standardTable_Row7"
                         style="border-color:#3f3e23;" rendered="#{colposcopiaBean.renderGrado1}">
             <h:panelGroup>
                <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                      id="mnuHallazgoGrado1"
                                      value="#{colposcopiaBean.lstGrado1Select}" 
                                      layout="pageDirection">
                  <f:selectItems value="#{colposcopiaBean.lstGrado1}"/>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHallazgoGrado1" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>    
             </h:panelGrid>
             
                 <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelHallazgoGrado2" rowClasses="standardTable_Row7,standardTable_Row7"
                         style="border-color:#3f3e23;"rendered="#{colposcopiaBean.renderGrado2}">
                           <h:panelGroup>
                <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                      id="mnuHallazgoGrado2"
                                      value="#{colposcopiaBean.lstGrado2Select}" 
                                      layout="pageDirection">
                  <f:selectItems value="#{colposcopiaBean.lstGrado2}"/>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHallazgoGrado2" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>    
             </h:panelGrid>
              
             
              </h:panelGrid>
              
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelDatosColposcopiaSospechaUbicacion"
                       rowClasses="labelText,labelTextInfo">
                       
            <h:outputText value = "Sospecha de Invasión"/>
            
            <h:outputText value = "Ubicación de la lesión "/>
                       
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelSospechaInvacion" rowClasses="standardTable_Row8,standardTable_Row8"
                         style="border-color:#3f3e23;">
                <a4j:region renderRegionOnly="false">
                <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                      id="mnuSospecha"
                                      value="#{colposcopiaBean.lstSospechaSelect}" 
                                      valueChangeListener="#{colposcopiaBean.setLstSospechaSelect}"
                                      layout="pageDirection">
                  <f:selectItems value="#{colposcopiaBean.lstSospecha}"/>
                   <a4j:support id="supportmnuSospecha" event="onclick" immediate="true"
                                 action="#{colposcopiaBean.changeSospecha}"
                                 reRender="panelCualSospecha">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  
                  
                </h:selectManyCheckbox>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuSospecha" styleClass="errorMessage"/>
                </a4j:outputPanel>
                
              
                <h:panelGroup id="panelCualSospecha" rendered="true">
                <h:outputText value="Cúal? " styleClass="labelTextOblig"
                              rendered="#{colposcopiaBean.renderOtraSospecha}" />
                <h:inputText id="itCualSospecha" style="width:300px" maxlength="100"  required="true"
                            rendered="#{colposcopiaBean.renderOtraSospecha}"
                              value="#{colposcopiaBean.coloposcopia.hclcsospecual}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualSospecha" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              </h:panelGrid>
              
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="2" width="500px"
                         id="panelUbicacionLesion" rowClasses="standardTable_Row8,standardTable_Row7"
                         style="border-color:#3f3e23;">
                         
                       
                         <h:outputText value = " Dentro de la zona de transformación"/>
                         <h:outputText value = " Con límite visible"/>
                      <h:panelGroup>
                       <h:outputText value = "Hora:" />
                         <h:inputText id="itDentroZona" style="width:40px" maxlength="2" required="false"
                                   value="#{colposcopiaBean.coloposcopia.hclcubicadentr}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDentroZona" styleClass="errorMessage"/>
                </a4j:outputPanel>
                        
                        <h:outputText value = " - "/>
                         <h:outputText value = "Hora:" />
                         <h:panelGroup>
                         <h:inputText id="itDentroZonaFin" style="width:40px" maxlength="2" required="false"
                                   value="#{colposcopiaBean.coloposcopia.hclcubicadentr2}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDentroZonaFin" styleClass="errorMessage"/>
                </a4j:outputPanel>
                
                         </h:panelGroup>
                        
                        
                         </h:panelGroup>
                            <h:panelGroup>
                           <h:selectOneRadio id="mnuLimiteTransformacionDentro" 
                                        value="#{colposcopiaBean.coloposcopia.hclclimident}"
                                        styleClass="labelRadio">
                                        <f:selectItems value="#{colposcopiaBean.lstOpcionesSi}"/>
                            </h:selectOneRadio>
                            
                                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuLimiteTransformacionDentro" styleClass="errorMessage"/>
                </a4j:outputPanel>
                        </h:panelGroup>
                         
                         
                        
                         <h:outputText value = "Fuera de la zona de transformación"/>
                          <h:outputText value = "Con límite visible"/>
                      	<h:panelGroup>
                        <h:outputText value = "Hora:" />
                            <h:inputText id="itFueraZona" style="width:40px" maxlength="2" required="false"
                                   value="#{colposcopiaBean.coloposcopia.hclcubicafuera}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itFueraZona" styleClass="errorMessage"/>
                </a4j:outputPanel>
               
			    <h:outputText value = " - "/>
				 <h:outputText value = "Hora:" />
				 <h:inputText id="itFueraZonaFin" style="width:40px" maxlength="2" required="false"
                                   value="#{colposcopiaBean.coloposcopia.hclcubicafuera2}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itFueraZonaFin" styleClass="errorMessage"/>
                </a4j:outputPanel>
                
			   
			   
			   </h:panelGroup>	
                        <h:panelGroup>
                           <h:selectOneRadio id="mnuLimiteTransformacionFuera" 
                                        value="#{colposcopiaBean.coloposcopia.hclclimifuer}"
                                        styleClass="labelRadio">
                                        <f:selectItems value="#{colposcopiaBean.lstOpcionesSi}"/>
                            </h:selectOneRadio>
                            
                             <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuLimiteTransformacionFuera" styleClass="errorMessage"/>
                </a4j:outputPanel>
                        </h:panelGroup>
                         
                         
                         <h:outputText value = "N° de cuadrantes"/>
                          <h:outputText value = ""/>
                         <h:panelGroup>
                                  <h:inputText id="itCuadrantes" style="width:40px" maxlength="2" required="false"
                                   value="#{colposcopiaBean.coloposcopia.hclcubicacuadr}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCuadrantes" styleClass="errorMessage"/>
                </a4j:outputPanel>
                         </h:panelGroup>
                          <h:outputText value = ""/>
                          
                         
                         
                         <h:outputText value = "Porcentaje del cuello Uterino"/>
                          <h:outputText value = ""/>
                         <h:panelGroup>
                          <h:inputText id="itCuelloUterino" style="width:40px" maxlength="2" required="false"   
                                   value="#{colposcopiaBean.coloposcopia.hclcubicaporce}" />
                                   <h:outputText value = "%"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCuelloUterino" styleClass="errorMessage"/>
                </a4j:outputPanel>
                         
                         </h:panelGroup>
                          <h:outputText value = ""/>
                </h:panelGrid>
        
        
        </h:panelGrid>
        
        
       
                
              
              
        </s:fieldset>
    
    <s:fieldset legend="No Especificos" id="fieldSetColposcopiaNoEspecificos" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="2" width="500px"
                       id="panelHallazgoNoEspecifico" rowClasses="standardTable_Row7,standardTable_Row7"
                       style="border-color:#3f3e23;">
            <h:panelGroup>
              <h:outputText value="Test de Schiller"/>
              <h:selectOneRadio id="mnuGradoNoEspecifico" value="#{colposcopiaBean.coloposcopia.hclcgrad3test}" required="true"
                                styleClass="labelRadio">
                <f:selectItems value="#{colposcopiaBean.lstOpciones}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuEvaluacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Leucoplasia"/>
              <h:selectOneRadio id="mnuGradoNoEspecifico2" value="#{colposcopiaBean.coloposcopia.hclchallaleuco}" required="true"
                                styleClass="labelRadio">
                <f:selectItems value="#{colposcopiaBean.lstOpcionesSi}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuGradoNoEspecifico2" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Erosión"/>
              <h:selectOneRadio id="mnuGradoNoEspecifico3" value="#{colposcopiaBean.coloposcopia.hclcgrad3erosi}" required="true"
                                styleClass="labelRadio">
                <f:selectItems value="#{colposcopiaBean.lstOpcionesSi}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuGradoNoEspecifico3" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        
         <s:fieldset legend="Biopsia" id="fieldObservacionTomoBiopsa" styleClass="fieldset">
        
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelDatosTomoBiopsa"
                       rowClasses="labelText,labelTextInfo">
                       
            <h:outputText value = "Tomo Biopsia " styleClass="labelTextOblig"/>           
             <h:outputText/>
             <h:panelGroup id="panelTextObservaciones">
             <h:outputText value = "Origen de la pieza"
             rendered="#{colposcopiaBean.renderTomaBiopsa}"/>          
             </h:panelGroup>
             <h:outputText/>          
             
             
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuTomoBiopsa" immediate="true" required="true"
                            value="#{colposcopiaBean.coloposcopia.hclctomobiop}"
                            valueChangeListener="#{colposcopiaBean.setHclctomobiop}"
                                styleClass="labelRadio">
                <f:selectItems value="#{colposcopiaBean.lstOpcionesSi}"/>
                <a4j:support id="supportMnuTomoBiopsa" event="onclick" immediate="true"
                                 action="#{colposcopiaBean.changeTomoBiopsa}"
                                 reRender="panelTextObservaciones,panelInputObservaciones">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
              </h:selectOneRadio>
              </a4j:region>
              
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCuelloUterino" styleClass="errorMessage"/>
                </a4j:outputPanel>
                
         <h:panelGroup id = "panelInputObservaciones">
              <h:inputTextarea id="itObservacionBiopsa" onkeydown="return blockEnter(event);" required="true"
                           title="Observacion Biopsa"
                           rendered="#{colposcopiaBean.renderTomaBiopsa}"
                           value="#{colposcopiaBean.coloposcopia.hclcobsebiop}" 
                           style="width:200px">
                           <f:validateLength maximum="1000"/>
                           </h:inputTextarea>
           
            </h:panelGroup>
            
              <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCuelloUterino" styleClass="errorMessage"/>
                </a4j:outputPanel>
             
        </h:panelGrid>
        </s:fieldset>
        
            <s:fieldset legend="Descripción del procedimiento" id="fieldObservacionColposcopia" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelDatosObservacionColposcopia"
                         rowClasses="labelText">
              <h:outputText value="Descripción del procedimiento:"/>
              <h:panelGroup>
                <h:inputTextarea id="textObservacionesColposcopia" onkeydown="return blockEnter(event);"
                                 value="#{colposcopiaBean.coloposcopia.hclcobservacio}"
                                 style="width:600px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textObservacionesColposcopia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
        
        
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionColposcopiaMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationColposcopiaMsg" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesColposcopia"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="boton_fieldset" action="#{colposcopiaBean.aceptar}">
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