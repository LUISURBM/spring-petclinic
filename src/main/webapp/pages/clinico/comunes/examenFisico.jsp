<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridExamenFisicoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" 
                    activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneExamenFisico" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabExamenFisico" label="Examen Fisico">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsExamenFisico"
                   styleClass="tabContainer">
        <s:fieldset legend="Datos Examen Fisico" id="fieldExamenFisico" styleClass="fieldset">
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosExamen"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Presión Arterial"
                            styleClass="#{(!examenFisicoUsuarioBean.campoopcional) ? \'labelTextOblig\' : \'\'}"/>
              <h:outputText value="Frecuencia Cardiaca"
                            styleClass="#{(!examenFisicoUsuarioBean.campoopcional) ? \'labelTextOblig\' : \'\'}"/>
              <h:outputText value="Frecuencia Respiratoria"
                            styleClass="#{(!examenFisicoUsuarioBean.campoopcional) ? \'labelTextOblig\' : \'\'}"/>
                <h:panelGroup id="panelTituloSpo2">
                <h:outputText value="SPO2"  rendered="#{examenFisicoUsuarioBean.renderedSpo2}"/>
              </h:panelGroup>             
              <h:panelGroup>
                <h:inputText id="itPresion" title="mm Hg" required="#{!examenFisicoUsuarioBean.campoopcional}"
                             onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.presionArterial1}"
                             style="width:30px" maxlength="3"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPresion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="/"/>
                <h:inputText id="itPresion2" title="mm Hg" required="#{!examenFisicoUsuarioBean.campoopcional}"
                             onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.presionArterial2}"
                             style="width:30px" maxlength="3"/>
                <h:outputText value="  mm Hg"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPresion2" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itCardiaca" title="latidos por minuto" onkeydown="return blockEnter(event);"
                             required="#{!examenFisicoUsuarioBean.campoopcional}"
                             value="#{examenFisicoUsuarioBean.examen.hefnfreccard}" style="width:30px" maxlength="3"/>
                <h:outputText value="  l.p.m"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCardiaca" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itRespiratoria" title="respiraciones por minuto" onkeydown="return blockEnter(event);"
                             required="#{!examenFisicoUsuarioBean.campoopcional}"
                             value="#{examenFisicoUsuarioBean.examen.hefnfrecresp}" style="width:30px" maxlength="2"/>
                <h:outputText value="  r.p.m"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itRespiratoria" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelInputSpo2">
                <h:inputText id="itSpo2" 
                             onkeydown="return blockEnter(event);"
                             rendered="#{examenFisicoUsuarioBean.renderedSpo2}" 
                             value="#{examenFisicoUsuarioBean.examen.hefnspo2}" style="width:50px" maxlength="3">
                             <f:validateLongRange minimum = "0" maximum = "100" />
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true" rendered="#{examenFisicoUsuarioBean.renderedSpo2}">
                  <t:message for="itSpo2" styleClass="errorMessage"/>
                </a4j:outputPanel>
                  <h:outputText value="  %" rendered="#{examenFisicoUsuarioBean.renderedSpo2}"/>
              </h:panelGroup>
              
              <h:outputText value="Peso"
                            styleClass="#{(!examenFisicoUsuarioBean.campoopcional) ? \'labelTextOblig\' : \'\'}"/>
              <h:outputText value="Talla"
                            styleClass="#{(!examenFisicoUsuarioBean.campoopcional) ? \'labelTextOblig\' : \'\'}"/>
              <h:outputText value="IMC"
                            styleClass="#{(!examenFisicoUsuarioBean.campoopcional) ? \'labelTextOblig\' : \'\'}"/>
              <h:outputText value="" />            
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itPeso" required="#{!examenFisicoUsuarioBean.campoopcional}"
                                 onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.peso}"
                                 valueChangeListener="#{examenFisicoUsuarioBean.setPeso}" style="width:40px"
                                 maxlength="4" title="Peso en Kilogramos">
                      <a4j:support id="supportPesoIMC" event="onchange" action="#{examenFisicoUsuarioBean.calcularIMC}"
                                   reRender="itIndiceMasaCorporal">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itPeso" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:outputText value="  kg"/>
                  </h:panelGroup>
                </h:panelGroup>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:inputText id="itTalla" title="Talla en metros" required="#{!examenFisicoUsuarioBean.campoopcional}"
                               onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.talla}"
                               valueChangeListener="#{examenFisicoUsuarioBean.setTalla}" style="width:40px"
                               maxlength="4">
                    <a4j:support id="supportIMC" event="onchange" action="#{examenFisicoUsuarioBean.calcularIMC}"
                                 reRender="itIndiceMasaCorporal">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itTalla" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value="  mts  "/>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="itIndiceMasaCorporal">
                <h:outputText id="itMasaCorporal" value="#{examenFisicoUsuarioBean.masacor}" style="width:30px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itMasaCorporal" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value="" />
              <h:panelGroup id="panelTextTemperatura">
                <h:outputText value="Temperatura"  styleClass="labelTextOblig" rendered="#{examenFisicoUsuarioBean.obligatoriaTemperatura}"/>
                <h:outputText value="Temperatura" rendered="#{!examenFisicoUsuarioBean.obligatoriaTemperatura}"/>
              </h:panelGroup>
               <h:outputText value=""/>
               <h:outputText value=""/>
               <h:outputText value="" />
              <h:panelGroup id="panelInputTemperatura">
                <h:inputText id="itTemperaura" 
                             onkeydown="return blockEnter(event);"
                             required="#{examenFisicoUsuarioBean.obligatoriaTemperatura}"
                             title="Temperatura en grados centígrados"
                             value="#{examenFisicoUsuarioBean.examen.hefatemperatu}" style="width:50px" maxlength="3"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itTemperaura" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="  ºC" />
              </h:panelGroup>

              <h:panelGroup>
                <h:outputText value="Perímetro Cefálico" rendered="#{examenFisicoUsuarioBean.esPediatria}"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value="Saturación de oxihemoglobina" rendered="#{examenFisicoUsuarioBean.esPediatria}"/>
              </h:panelGroup>
              <h:outputText value=""/>

              <h:panelGroup>
                <h:inputText id="itPerimetro" title="perimetro en centímetros" onkeydown="return blockEnter(event);"
                             value="#{examenFisicoUsuarioBean.examen.hefnpericefali}"
                             rendered="#{examenFisicoUsuarioBean.esPediatria}" style="width:20px" maxlength="2"/>
                <h:outputText value="   cm" rendered="#{examenFisicoUsuarioBean.esPediatria}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPerimetro" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itSaturacion" onkeydown="return blockEnter(event);"
                             rendered="#{examenFisicoUsuarioBean.esPediatria}"
                             value="#{examenFisicoUsuarioBean.examen.hefnsatuoxihe}" style="width:30px" maxlength="3"/>
                <h:outputText value="    O2" rendered="#{examenFisicoUsuarioBean.esPediatria}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itSaturacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="4" border="0" width="100%" id="panelDatosdeDiscapacidad">
              <h:outputText value="Discapacidad" 
                            styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelTipoDiscapacidad1">
                <h:outputText value="Tipos de Discapacidad" rendered="#{examenFisicoUsuarioBean.renderDiscapacidad}"
                              styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="radioDiscapacidad" value="#{examenFisicoUsuarioBean.examen.hefcdiscapadid}"
                                 required="#{!examenFisicoUsuarioBean.campoopcional}" >
                <f:selectItem itemValue="S" itemLabel="SI"/>
                <f:selectItem itemValue="N" itemLabel="NO"/>
                <a4j:support id="supportmnumnuDiscapacidad" action="#{examenFisicoUsuarioBean.changeDiscapacidad}"
                             reRender="panelTipoDiscapacidad1,panelDiscapaci" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="radioDiscapacidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelDiscapaci">
                <h:selectOneMenu id="panelDiscapacidad" rendered="#{examenFisicoUsuarioBean.renderDiscapacidad}"
                                 immediate="true" value="#{examenFisicoUsuarioBean.examen.hefcdiscaselec}" required="true">
                  <f:selectItems value="#{examenFisicoUsuarioBean.lstDiscapacidad}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="panelDiscapacidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosExamenEstadoPacienteAlIngresar" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Estado del paciente al momento de la consulta"
                            styleClass="#{(!examenFisicoUsuarioBean.campoopcional) ? \'labelTextOblig\' : \'\'}"/>
              <h:outputText/>
              <h:inputTextarea id="textHallazgos" required="#{!examenFisicoUsuarioBean.campoopcional}"
                               value="#{examenFisicoUsuarioBean.examen.hefthallazgo}" style="width:600px;height:80px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textHallazgos" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </a4j:region>
        </s:fieldset>
        
        
         <s:fieldset legend="Escala de Dolor" id="fieldExamenFisicoEscalaDolor" styleClass="fieldset"
         rendered="#{examenFisicoUsuarioBean.renderEscala}">
          
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosEscalaDolor"
                         rowClasses="labelText,labelTextInfo">
                         
                           <h:outputText value="Escala de Dolor" styleClass="labelTextOblig"/>
                              <h:outputText value=""/>
                              
                               <h:outputText value="Duración del dolor" styleClass="labelTextOblig"/>
                                <h:panelGroup id = "itTextUnidadMedida">
                                        <h:outputText value="Unidad de Medida"  rendered="#{examenFisicoUsuarioBean.renderDolor}"
                                                        styleClass="labelTextOblig"/>
               </h:panelGroup>
                              
                                <h:panelGroup>
                <h:selectOneRadio id="selectEscalaDolor" layout="lineDirection"
                                  value="#{examenFisicoUsuarioBean.examen.hefnescadolor}"
                                  style="margin-left:55px; width:580px">
                  <f:selectItems value="#{examenFisicoUsuarioBean.listEscala}"/>
                </h:selectOneRadio>
                <h:graphicImage url="/comun/imagenes/escalaDolor2.png" style="width:650px"/>
              </h:panelGroup>
              
                <a4j:outputPanel ajaxRendered="true">
                <t:message for="selectEscalaDolor" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
                <h:panelGroup>
                <h:inputText id="menuDuraDolor" maxlength="2" size="2" immediate="true"
                             value="#{examenFisicoUsuarioBean.examen.hefnduradolor}"
                             onkeypress="return justNumbers(event);">
                              <a4j:support event="onchange" status="statusButton"/>
                             </h:inputText>
                <h:selectOneMenu id="menuTiempo3" styleClass="input-small labelTextOblig" immediate="true" 
                value="#{examenFisicoUsuarioBean.examen.hefcdudointen}">
                    <f:selectItem itemLabel="Seleccione una opción ..." itemValue=""/>
                    <f:selectItem itemLabel="Minuto(s)" itemValue="MI"/>
                    <f:selectItem itemLabel="Hora(s)" itemValue="H"/>
                    <f:selectItem itemLabel="Día(s)" itemValue="D"/>
                    <f:selectItem itemLabel="Semana(s)" itemValue="S"/>
                </h:selectOneMenu>
               
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuDuraDolor" styleClass="errorMessage"/>
              </a4j:outputPanel>
                              
          
            
            </h:panelGrid>  
        
        </s:fieldset>
        <s:fieldset legend="Hallazgos Examen Físico" id="fieldHallazgos" styleClass="fieldset">
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="12">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{examenFisicoUsuarioBean.changeTodosSi}" reRender="panelHallazgosExamenFisico"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos SIN ALTERACIONES "
                               immediate="true" action="#{examenFisicoUsuarioBean.changeTodosSinAL}"
                               reRender="panelHallazgosExamenFisico"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{examenFisicoUsuarioBean.changeTodosNo}" reRender="panelHallazgosExamenFisico"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos EVALUADO-SIN HALLAZGO "
                               immediate="true" action="#{examenFisicoUsuarioBean.changeTodosEvaluado}"
                               reRender="panelHallazgosExamenFisico"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{examenFisicoUsuarioBean.changeNinguno}" reRender="panelHallazgosExamenFisico"/>
              <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelHallazgosExamenFisico"
                       rowClasses="standardTable_ExamenFisico,standardTable_ExamenFisico2">
            <h:outputText value="  Piel y faneras" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuPiel" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuPiel}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefiepiel}"
                                value="#{examenFisicoUsuarioBean.examen.heferefiepiel}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuPiel" action="#{examenFisicoUsuarioBean.changePiel}"
                             reRender="panelOutputPiel,panelInputPiel" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuPiel" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputPiel">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderPiel}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputPiel">
              <h:inputTextarea id="itPiel" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderPiel}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefiepiel}"
                               rendered="#{examenFisicoUsuarioBean.renderPiel}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itPiel" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Craneo" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuCraneo" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuCraneo}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefiecrane}"
                                value="#{examenFisicoUsuarioBean.examen.heferefiecrane}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuCraneo" action="#{examenFisicoUsuarioBean.changeCraneo}"
                             reRender="panelOutputCraneo,panelInputCraneo" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCraneo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputCraneo">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderCraneo}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputCraneo">
              <h:inputTextarea id="itCraneo" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderCraneo}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefiecrane}"
                               rendered="#{examenFisicoUsuarioBean.renderCraneo}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itCraneo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Ojos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuOjos" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuOjos}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefieojos}"
                                value="#{examenFisicoUsuarioBean.examen.heferefieojos}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuOjos" action="#{examenFisicoUsuarioBean.changeOjos}"
                             reRender="panelOutputOjos,panelInputOjos" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuOjos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputOjos">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderOjos}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputOjos">
              <h:inputTextarea id="itOjos" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderOjos}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefieojos}"
                               rendered="#{examenFisicoUsuarioBean.renderOjos}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itOjos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Oídos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuOidos" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuOidos}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefieoidos}"
                                value="#{examenFisicoUsuarioBean.examen.heferefieoidos}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuOidos" action="#{examenFisicoUsuarioBean.changeOidos}"
                             reRender="panelOutputOidos,panelInputOidos" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuOidos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputOidos">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderOidos}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputOidos">
              <h:inputTextarea id="itOidos" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderOidos}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefieoidos}"
                               rendered="#{examenFisicoUsuarioBean.renderOidos}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itOidos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Nariz: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuNariz" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuNariz}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefienariz}"
                                value="#{examenFisicoUsuarioBean.examen.heferefienariz}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuNariz" action="#{examenFisicoUsuarioBean.changeNariz}"
                             reRender="panelOutputNariz,panelInputNariz" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuNariz" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputNariz">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderNariz}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputNariz">
              <h:inputTextarea id="itNariz" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderNariz}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefienariz}"
                               rendered="#{examenFisicoUsuarioBean.renderNariz}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNariz" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Boca: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuBoca" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuBoca}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefieboca}"
                                value="#{examenFisicoUsuarioBean.examen.heferefieboca}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuBoca" action="#{examenFisicoUsuarioBean.changeBoca}"
                             reRender="panelOutputBoca,panelInputBoca" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuBoca" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputBoca">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderBoca}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputBoca">
              <h:inputTextarea id="itBoca" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderBoca}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefieboca}"
                               rendered="#{examenFisicoUsuarioBean.renderBoca}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itBoca" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Cuello: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuCuello" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuCuello}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefiecuell}"
                                value="#{examenFisicoUsuarioBean.examen.heferefiecuell}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuCuello" action="#{examenFisicoUsuarioBean.changeCuello}"
                             reRender="panelOutputCuello,panelInputCuello" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCuello" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputCuello">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderCuello}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputCuello">
              <h:inputTextarea id="itCuello" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderCuello}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefiecuell}"
                               rendered="#{examenFisicoUsuarioBean.renderCuello}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itCuello" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Tórax y pulmones:  " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuTorax" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuTorax}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefietorax}"
                                value="#{examenFisicoUsuarioBean.examen.heferefietorax}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuTorax" action="#{examenFisicoUsuarioBean.changeTorax}"
                             reRender="panelOutputTorax,panelInputTorax" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuTorax" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputTorax">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderTorax}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputTorax">
              <h:inputTextarea id="itTorax" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderTorax}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefietorax}"
                               rendered="#{examenFisicoUsuarioBean.renderTorax}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itTorax" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Corazón: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuCorazon" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuCorazon}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefiecoraz}"
                                value="#{examenFisicoUsuarioBean.examen.heferefiecoraz}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuCorazon" action="#{examenFisicoUsuarioBean.changeCorazon}"
                             reRender="panelOutputCorazon,panelInputCorazon" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCorazon" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputCorazon">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderCorazon}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputCorazon">
              <h:inputTextarea id="itCorazon" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderCorazon}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefiecoraz}"
                               rendered="#{examenFisicoUsuarioBean.renderCorazon}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itCorazon" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Mamas: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuSenos" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuSenos}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefiesenos}"
                                value="#{examenFisicoUsuarioBean.examen.heferefiesenos}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuSenos" action="#{examenFisicoUsuarioBean.changeSenos}"
                             reRender="panelOutputSenos,panelInputSenos" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuSenos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputSenos">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderSenos}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputSenos">
              <h:inputTextarea id="itSenos" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderSenos}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefiesenos}"
                               rendered="#{examenFisicoUsuarioBean.renderSenos}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itSenos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Abdomen: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuAbdomen" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuAbdomen}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefieabdom}"
                                value="#{examenFisicoUsuarioBean.examen.heferefieabdom}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuAbdomen" action="#{examenFisicoUsuarioBean.changeAbdomen}"
                             reRender="panelOutputAbdomen,panelInputAbdomen" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAbdomen" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputAbdomen">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderAbdomen}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputAbdomen">
              <h:inputTextarea id="itAbdomen" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderAbdomen}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefieabdom}"
                               rendered="#{examenFisicoUsuarioBean.renderAbdomen}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itAbdomen" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Genitales: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuGenitales" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuGenitales}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefiegenit}"
                                value="#{examenFisicoUsuarioBean.examen.heferefiegenit}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuGenitales" action="#{examenFisicoUsuarioBean.changeGenitales}"
                             reRender="panelOutputGenitales,panelInputGenitales" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuGenitales" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputGenitales">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderGenitales}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputGenitales">
              <h:inputTextarea id="itGenitales" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderGenitales}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefiegenit}"
                               rendered="#{examenFisicoUsuarioBean.renderGenitales}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itGenitales" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup rendered="#{!examenFisicoUsuarioBean.renderMaculino}">
              <h:outputText value="  Tacto vaginal : " styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup rendered="#{!examenFisicoUsuarioBean.renderMaculino}">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuTacto" required="true" immediate="true" layout="pageDirection"
                                  binding="#{examenFisicoUsuarioBean.mnuTacto}"
                                  valueChangeListener="#{examenFisicoUsuarioBean.setHeferefietacto}"
                                  value="#{examenFisicoUsuarioBean.examen.heferefietacto}">
                  <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                  <a4j:support id="supportmnumnuTacto" action="#{examenFisicoUsuarioBean.changeTacto}"
                               reRender="panelOutputTacto,panelInputTacto" event="onclick">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
            </h:panelGroup>
            <h:panelGroup rendered="#{!examenFisicoUsuarioBean.renderMaculino}">
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTacto" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup rendered="#{!examenFisicoUsuarioBean.renderMaculino}">
              <h:panelGroup id="panelOutputTacto">
                <h:outputText value="Descripción " styleClass="labelTextOblig"
                              rendered="#{examenFisicoUsuarioBean.renderTacto}"/>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup rendered="#{!examenFisicoUsuarioBean.renderMaculino}">
              <h:panelGroup id="panelInputTacto">
                <h:inputTextarea id="itTacto" style="width:200px" onkeydown="return blockEnter(event);"
                                 required="#{examenFisicoUsuarioBean.renderTacto}"
                                 value="#{examenFisicoUsuarioBean.examen.hefcrefietacto}"
                                 rendered="#{examenFisicoUsuarioBean.renderTacto}"/>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup rendered="#{!examenFisicoUsuarioBean.renderMaculino}">
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTacto" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="  Extremidades: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuExtremidades" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuExtremidades}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefieextre}"
                                value="#{examenFisicoUsuarioBean.examen.heferefieextre}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuExtremidades" action="#{examenFisicoUsuarioBean.changeExtremidades}"
                             reRender="panelOutputExtremidades,panelInputExtremidades" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExtremidades" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputExtremidades">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderExtremidades}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputExtremidades">
              <h:inputTextarea id="itExtremidades" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderExtremidades}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefieextre}"
                               rendered="#{examenFisicoUsuarioBean.renderExtremidades}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itExtremidades" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="  Neuromuscular: " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuNeuromuscular" required="true" immediate="true" layout="pageDirection"
                                binding="#{examenFisicoUsuarioBean.mnuNeuromuscular}"
                                valueChangeListener="#{examenFisicoUsuarioBean.setHeferefieneuro}"
                                value="#{examenFisicoUsuarioBean.examen.heferefieneuro}">
                <f:selectItems value="#{examenFisicoUsuarioBean.lstAlteraciones}"/>
                <a4j:support id="supportmnumnuNeuromuscular" action="#{examenFisicoUsuarioBean.changeNeuromuscular}"
                             reRender="panelOutputNeuromuscular,panelInputNeuromuscular" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuNeuromuscular" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelOutputNeuromuscular">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renderNeuromuscular}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputNeuromuscular">
              <h:inputTextarea id="itNeuromuscular" style="width:200px" onkeydown="return blockEnter(event);"
                               required="#{examenFisicoUsuarioBean.renderNeuromuscular}"
                               value="#{examenFisicoUsuarioBean.examen.hefcrefieneuro}"
                               rendered="#{examenFisicoUsuarioBean.renderNeuromuscular}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNeuromuscular" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
  
   <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" 
                        id="panelTieneDatosExamenBimanual" rowClasses="labelText,labelTextInfo" rendered="#{examenFisicoUsuarioBean.renderedInterrupcion}">
           
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosTieneCiclos" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Hallazgos ecográficos por: " styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="radioTipoCiclo" immediate="true" required="false" 
                value="#{examenFisicoUsuarioBean.examen.hefcecoespecialis}"
                                 valueChangeListener="#{examenFisicoUsuarioBean.setEcografiaEsp}">
                  <f:selectItems value="#{examenFisicoUsuarioBean.lstEcografia}"/>
                  <a4j:support id="support" event="onchange" immediate="true"  action="#{examenFisicoUsuarioBean.changeTipoHallazgo}" 
                  reRender="mnuEcoEspMedida,panelTextDatosObservacionEcografia,panelDatosObservacionEcografia,mnuEcoEspMedidaUtero">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="radioTipoCiclo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGrid>
            
                      
            <h:panelGroup id="mnuEcoEspMedida">
            
              <h:panelGrid columns="1" rendered="#{examenFisicoUsuarioBean.rastreoEco}">
                <h:outputText value="Edad gestacional en semanas" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:panelGrid columns="3" border="0" cellpadding="3" cellspacing="0" width="50%" id="panelEdadges" rowClasses="labelText,labelTextInfo">
                  <h:panelGroup>
                    <h:inputText id="itEdadgest" title="Edad Gestacional Semanas" 
                     onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.examen.hefnedadsem}"
                     style="width:30px" required="true"
                                 maxlength="2"/>
                                 
                      <a4j:outputPanel ajaxRendered="true">
                            <t:message for="itEdadgest" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                  </h:panelGroup>
                    <h:outputText value=" + "/>
                       <h:panelGroup>
                    <h:inputText id="itEdadgestd" title="Edad Gestacional dias" onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.examen.hefnedaddia}" style="width:30px" required="true" 
                                 maxlength="1"/>
                                 <a4j:outputPanel ajaxRendered="true">
                            <t:message for="itEdadgestd" styleClass="errorMessage"/>
                        </a4j:outputPanel>  
                            </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                
                
                <h:panelGroup id="mnuEcoEspMedidaUtero">
                  <h:panelGrid columns="1" rendered="#{examenFisicoUsuarioBean.ecgrafiaoEco}">
                    <h:outputText value="Tamaño del útero" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <h:panelGrid columns="3" border="0" cellpadding="3" cellspacing="0" width="50%" id="panelTamUtero" rowClasses="labelText,labelTextInfo">
                      <h:panelGroup>
                        <h:inputText id="itdatoCent" required="true" title="Centimetros" onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.examen.hefntamauterocm}" style="width:30px"
                                     maxlength="2"/>
                                                   
                      <a4j:outputPanel ajaxRendered="true">
                            <t:message for="itdatoCent" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                        </h:panelGroup>
                        <h:outputText value=" , "/>
                        <h:panelGroup>
                        <h:inputText id="itdatodecimal"  required="true" title="Decimales" 
                        onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.examen.hefntamauteroml}" style="width:30px"
                                     maxlength="1"/>
                                       <a4j:outputPanel ajaxRendered="true">
                            <t:message for="itdatodecimal" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                        </h:panelGroup>
                      </h:panelGrid>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGroup>
            
             <h:panelGroup id="panelTextDatosObservacionEcografia">
                     <h:outputText value="Observaciones" rendered="#{examenFisicoUsuarioBean.rastreoEco || examenFisicoUsuarioBean.ecgrafiaoEco}" styleClass="labelTextOblig"/>
                </h:panelGroup>
                 <h:panelGroup id="panelDatosObservacionEcografia">
                    <h:inputTextarea id="textObservacionesEcografia" onkeydown="return blockEnter(event);"
                    value="#{examenFisicoUsuarioBean.examen.hefcobsereco}" style="width:400px"
                             rendered="#{examenFisicoUsuarioBean.rastreoEco || examenFisicoUsuarioBean.ecgrafiaoEco}"/>
                    <a4j:outputPanel ajaxRendered="true">
                     <t:message for="textObservacionesEcografia" styleClass="errorMessage"/>
                 </a4j:outputPanel>
             </h:panelGroup>
            </h:panelGrid>
        
        
        
          <s:fieldset legend="Se confirma embarazo en la consulta" id="fieldExamenFisicoConfirmaEmbarazo" 
                        styleClass="fieldset" rendered="#{examenFisicoUsuarioBean.renderedInterrupcion}">
        
          
           <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                        id="panelConfirmaEmbarazo" rowClasses="labelText,labelTextInfo">
               <h:panelGroup>         
                <h:outputText value = "Se confirma embarazo en la consulta"  styleClass="labelTextOblig" />
                  <a4j:region renderRegionOnly="false">
                 <h:selectOneRadio id="mnuConfirmaEmbarazo" immediate="true"
                 binding="#{examenFisicoUsuarioBean.mnuConfemb}"
                                  onkeydown="return blockEnter(event);" required="true"
                                  value="#{examenFisicoUsuarioBean.examen.hefcconfiembar}"
                                  valueChangeListener="#{examenFisicoUsuarioBean.setHefcconfiembar}">
                  <f:selectItems value="#{examenFisicoUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supportmnumnuConfembar" action="#{examenFisicoUsuarioBean.changeConfirmEmbarazo}"
                             reRender="panelOutputConfEmba,panelInputConfEmb" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                </h:selectOneRadio>
                   <a4j:outputPanel ajaxRendered="true">
                            <t:message for="mnuConfirmaEmbarazo" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                        </a4j:region>
               </h:panelGroup> 
               
             <h:panelGroup id="panelOutputConfEmba">
              <h:outputText value="Descripción " styleClass="labelTextOblig"
                            rendered="#{examenFisicoUsuarioBean.renerConfEmba}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputConfEmb">
              <h:inputTextarea id="itConfE" style="width:200px" onkeydown="return blockEnter(event);"
                               value="#{examenFisicoUsuarioBean.examen.hefcdesccfemb}"
                               rendered="#{examenFisicoUsuarioBean.renerConfEmba}"
                               required="#{examenFisicoUsuarioBean.renerConfEmba}"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itConfE" styleClass="errorMessage"/>
            </a4j:outputPanel>
        </h:panelGrid>
            </s:fieldset>
        
        
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                             action="#{examenFisicoUsuarioBean.guardarExamen}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
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